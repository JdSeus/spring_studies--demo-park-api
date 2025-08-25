package com.julianoseus.demo_park_api.service;

import com.julianoseus.demo_park_api.entity.Vaga;
import com.julianoseus.demo_park_api.exception.EntityNotFoundException;
import com.julianoseus.demo_park_api.repository.VagaRepository;
import com.julianoseus.demo_park_api.web.dto.ClienteResponseDto;
import com.julianoseus.demo_park_api.web.dto.UsuarioResponseDto;
import com.julianoseus.demo_park_api.web.dto.VagaResponseDto;
import com.julianoseus.demo_park_api.web.exception.CodigoUniqueViolationException;
import com.julianoseus.demo_park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class VagaService {

    private final VagaRepository vagaRepository;

    @Operation(summary = "Criar uma nova vaga", description = "Recurso para criar uma nova vaga. Requisição exige uso de um bearer token. Acesso restrito a Role='ADMIN'",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Recurso criado com sucesso",
                        headers = @Header(name = HttpHeaders.LOCATION, description = "URL do recurso criado")
                    ),
                    @ApiResponse(responseCode = "409", description = "Vaga já cadastrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class
                    ))),
                    @ApiResponse(responseCode = "422", description = "Recurso não processado por dados de entrada inválidos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class
                    ))),
            }
    )
    @Transactional
    public Vaga salvar(Vaga vaga) {
        try {
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException(String.format("Vaga com código '%s' já cadastrada", vaga.getCodigo()));
        }
    }

    @Operation(summary = "Localizar uma vaga", description = "Recurso para localizar uma vaga pelo seu código. Requisição exige uso de um bearer token. Acesso restrito a Role='ADMIN'",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Recurso localizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = VagaResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Vaga não localizada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class
                    ))),
                    @ApiResponse(responseCode = "403", description = "Recurso não permitido ao perfil de CLIENTE", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class
                    ))),
            }
    )
    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo) {
        return vagaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException(String.format("Vaga com código '%s' não foi encontrada", codigo))
        );
    }

}

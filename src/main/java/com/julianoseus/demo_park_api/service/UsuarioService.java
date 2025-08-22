package com.julianoseus.demo_park_api.service;

import com.julianoseus.demo_park_api.entity.Usuario;
import com.julianoseus.demo_park_api.exception.EntityNotFoundException;
import com.julianoseus.demo_park_api.exception.UsernameUniqueValidationException;
import com.julianoseus.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch(org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UsernameUniqueValidationException(String.format("Username (%s} já cadastrado", usuario.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado.", id))
        );
    }

    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if(!novaSenha.equals(confirmaSenha)) {
            throw new RuntimeException("Nova Senha não confere com confirmação de senha.");
        }
        Usuario user = buscarPorId(id);
        if(!user.getPassword().equals(senhaAtual)) {
            throw new RuntimeException("Sua senha não confere.");
        }

        user.setPassword((novaSenha));
        return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}

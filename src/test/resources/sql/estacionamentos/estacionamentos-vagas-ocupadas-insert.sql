INSERT INTO USUARIOS (id, username, password, role) VALUES (100, 'altrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_ADMIN');
INSERT INTO USUARIOS (id, username, password, role) VALUES (101, 'beltrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_CLIENTE');
INSERT INTO USUARIOS (id, username, password, role) VALUES (102, 'citrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_CLIENTE');

INSERT INTO clientes (id, nome, cpf, id_usuario) VALUES (21, 'Beltrano', '31918303088', 101);
INSERT INTO clientes (id, nome, cpf, id_usuario) VALUES (22, 'Citrano', '10390511030', 102);

INSERT INTO VAGAS (id, codigo, status) VALUES (100, 'A-01', 'OCUPADA');
INSERT INTO VAGAS (id, codigo, status) VALUES (200, 'A-02', 'OCUPADA');
INSERT INTO VAGAS (id, codigo, status) VALUES (300, 'A-03', 'OCUPADA');
INSERT INTO VAGAS (id, codigo, status) VALUES (400, 'A-04', 'OCUPADA');
INSERT INTO VAGAS (id, codigo, status) VALUES (500, 'A-05', 'OCUPADA');

INSERT INTO CLIENTES_TEM_VAGAS (numero_recibo, placa, marca, modelo, cor, data_entrada, id_cliente, id_vaga)
    VALUES ('20250825-143000', "FIT-1020", "FIAT", "PALIO", "VERDE", "2025-08-25 14:30:00", 22, 100);
INSERT INTO CLIENTES_TEM_VAGAS (numero_recibo, placa, marca, modelo, cor, data_entrada, id_cliente, id_vaga)
    VALUES ('20250825-153000', "SIE-1020", "FIAT", "SIENA", "BRANCO", "2025-08-25 15:30:00", 21, 200);
INSERT INTO CLIENTES_TEM_VAGAS (numero_recibo, placa, marca, modelo, cor, data_entrada, id_cliente, id_vaga)
    VALUES ('20250825-163000', "FIT-1030", "FIAT", "PALIO", "VERDE", "2025-08-25 16:30:00", 22, 300);


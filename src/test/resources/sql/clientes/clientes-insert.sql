INSERT INTO usuarios (id, username, password, role) VALUES (100, 'altrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_ADMIN');
INSERT INTO usuarios (id, username, password, role) VALUES (101, 'beltrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_CLIENTE');
INSERT INTO usuarios (id, username, password, role) VALUES (102, 'citrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_CLIENTE');
INSERT INTO usuarios (id, username, password, role) VALUES (103, 'deltrano@email.com', '$2a$12$3vsHeMzwlnHzMyq/xKkJquiCJBqXzCFRndrihjKhY5Y0F4leJIKg.', 'ROLE_CLIENTE');

INSERT INTO clientes (id, nome, cpf, id_usuario) VALUES (10, 'Beltrano', '31918303088', 101);
INSERT INTO clientes (id, nome, cpf, id_usuario) VALUES (20, 'Citrano', '10390511030', 102);


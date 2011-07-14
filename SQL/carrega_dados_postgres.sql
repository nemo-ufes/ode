INSERT INTO RECURSOHUMANO (id, uuid, version, nome, ativo)
VALUES (1, '9440682b-b0e8-4341-9179-bc623b89d083', 0, 'Ricardo de Almeida Falbo', true);
INSERT INTO RECURSOHUMANO (id, uuid, version, nome, ativo)
VALUES (2, '6b42720e-5b31-4971-a055-e244430d957f', 0, 'Alexandre Coelho', true);
INSERT INTO HIBERNATE_SEQUENCES (SEQUENCE_NAME, SEQUENCE_NEXT_HI_VALUE ) 
VALUES  ('RECURSOHUMANO', 1);

INSERT INTO NUCLEOUSERDETAILS (id, uuid, version, username, password, recursohumano_id)
VALUES (1, '36ac7738-b3bc-40cc-98ab-21c5f59db410', 0, 'admin', 'e8d95a51f3af4a3b134bf6bb680a213a',1);
INSERT INTO NUCLEOUSERDETAILS (id, uuid, version, username, password, recursohumano_id)
VALUES (2, '45as7738-b3bc-40cc-98ab-21c5f59db410', 0, 'alexandre.coelho', 'e8d95a51f3af4a3b134bf6bb680a213a',2);
INSERT INTO HIBERNATE_SEQUENCES (SEQUENCE_NAME, SEQUENCE_NEXT_HI_VALUE ) 
VALUES  ('NucleoUserDetails', 1);
INSERT INTO GRANTEDAUTHORITYIMPL (id, uuid, version, authority)
VALUES (1, '07d679c5-fe3b-411c-9d5b-1e2a343f76d7', 0, 'ROLE_SUPERVISOR');
INSERT INTO GRANTEDAUTHORITYIMPL (id, uuid, version, authority)
VALUES (2, '07d679c5-fe3b-411c-9d5b-1e2a343f76d7', 0, 'ROLE_SUPERVISOR');
INSERT INTO HIBERNATE_SEQUENCES (SEQUENCE_NAME, SEQUENCE_NEXT_HI_VALUE ) 
VALUES  ('NucleoGrantedAuthority', 1);
INSERT INTO NUCLEOUSERDETAILS_GRANTEDAUTHORITYIMPL
VALUES (1,1);
INSERT INTO NUCLEOUSERDETAILS_GRANTEDAUTHORITYIMPL 
VALUES (2,2);

INSERT INTO KTIPOINTERACAO (id, uuid, version, nome, descricao) VALUES (1, '65as7738-b3bc-40cc-98ab-21c5f59db410', 0, 'Sequencial', 'Tipo de Interacao Sequencial');
INSERT INTO KTIPOINTERACAO (id, uuid, version, nome, descricao) VALUES (2, '65as7738-b3bc-40cc-98ab-21c5f59db411', 0, 'Paralelo Independente', 'Tipo de Interacao Paralelo Independente');
INSERT INTO KTIPOINTERACAO (id, uuid, version, nome, descricao) VALUES (3, '65as7738-b3bc-40cc-98ab-21c5f59db412', 0, 'Paralelo Dependente', 'Tipo de Interacao Paralelo Dependente');
INSERT INTO KTIPOINTERACAO (id, uuid, version, nome, descricao) VALUES (4, '65as7738-b3bc-40cc-98ab-21c5f59db413', 0, 'Pontual', 'Tipo de Interacao Pontual');
INSERT INTO KTIPOINTERACAO (id, uuid, version, nome, descricao) VALUES (5, '65as7738-b3bc-40cc-98ab-21c5f59db414', 0, 'Sob-Demanda', 'Tipo de Interacao Sob-Demanda');

INSERT INTO KCATEGORIAPROCESSO (id, uuid, version, nome, descricao) VALUES (6, '65as7738-b3bc-40cc-98ab-21c5f59db415', 0, 'Fundamental', 'Categoria Fundamental');
INSERT INTO KCATEGORIAPROCESSO (id, uuid, version, nome, descricao) VALUES (7, '65as7738-b3bc-40cc-98ab-21c5f59db416', 0, 'Apoio', 'Categoria de Apoio');
INSERT INTO KCATEGORIAPROCESSO (id, uuid, version, nome, descricao) VALUES (8, '65as7738-b3bc-40cc-98ab-21c5f59db417', 0, 'Organizacional', 'Categoria Organizacional');

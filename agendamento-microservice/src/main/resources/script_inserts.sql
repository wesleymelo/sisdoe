--LOCAL_DOACAO

insert into public.local_doacao (id, nome, endereco, cidade, bairro, municipio,uf, cep, latitude, longitude) values

(nextval('hibernate_sequence'), 'Laboratório Sabin Paranoá', '30 22 19 01 - Paranoá, Brasília - DF, 69874-458', 'Paranoá', 'Avenida Paranoá', 'Brasília','DF', '69874458', -15.71489580,-47.87657690),

(nextval('hibernate_sequence'), 'Laboratório Sabin Ceilândia', 'Lote 01, St. M Qnm 17 Conjunto A - Ceilândia Sul, Brasília - DF, 72215-171', 'Ceilândia', 'Ceilândia Sul', 'Brasília','DF', '72215171', -15.81449860,-48.09847910),

(nextval('hibernate_sequence'), 'Laboratório Sabin Ceilândia - HRC', 'QNM 17 Cj H Lote 16/18, s/n - Ceilândia, Brasília - DF, 72215-178', 'Ceilândia', 'Ceilândia Sul', 'Brasília','DF', '72215178', -15.81587640,-48.09910760),

(nextval('hibernate_sequence'), 'Laboratório Sabin Ceilândia - HSF', 'Qnn 20 Cj O Lote 43 / Ceilandia Sul - H.s.f, Brasília - DF, 72220-215', 'Ceilândia', 'Ceilândia Sul', 'Brasília','DF', '72220215', -15.82806190,-48.11625730),

(nextval('hibernate_sequence'), 'Laboratório Sabin Ceilândia Norte', 'St. N Qnn 23 Conjunto J, 42 - Ceilândia, Brasília - DF, 72225-240', 'Ceilândia', 'Ceilândia Norte', 'Brasília','DF', '72225240', -15.80579390,-48.12449290),

(nextval('hibernate_sequence'), 'Hemocentro de Brasília', 'SMHN 3 Conjunto A Bloco 3 - Asa Norte, Brasília - DF, 70710-904', 'Brasília', 'Asa Norte', 'Brasília','DF', '70710904', -15.80942900,-47.89869910),

(nextval('hibernate_sequence'), 'Laboratório Sabin Samambaia Norte', 'QS 116 loja 6 - Samambaia Norte, Brasília - DF, 72302-707', 'Samambaia', 'Samambaia Norte', 'Brasília','DF', '72302707', -15.87164220,-48.07412640),

(nextval('hibernate_sequence'), 'Laboratório Sabin Recanto das Emas', 'Quadra 104, lotes de 8 a 11, 01 - Recanto das Emas, DF, 72600-402', 'Recanto das Emas', 'Recanto das Emas', 'Brasília','DF', '72600402', -15.90279200,-48.06870050),

(nextval('hibernate_sequence'), 'Centro Diagnóstico Cardiológico', 'Praça Dr. Tomás Ulhôa - Nossa Sra. da Abadia, Uberaba - MG, 38025-050', 'Uberaba', 'Nossa Senhora da Abadia', 'Uberaba','MG', '38025050', -19.75406210,-47.92988420),

(nextval('hibernate_sequence'), 'Clínica Radiológica Dr. Lauro Baptista Machado', 'R. Segismundo Mendes, 557 - Centro, Uberaba - MG, 38010-130', 'Uberaba', 'Rua Segismundo Mendes', 'Uberaba','MG', '38010130', -19.75130150,-47.93552520),

(nextval('hibernate_sequence'), 'Clínica Radiológica Uberaba', 'R. Santo Antônio, 150 - Centro, Uberaba - MG, 38010-160', 'Uberaba', 'Rua Santo Antônio', 'Uberaba','MG', '38010160', -19.75182230,-47.93574420),

(nextval('hibernate_sequence'), 'Hospital e Maternidade São Domingos', 'R. da Constituição, 751 - Nossa Sra. da Abadia, Uberaba - MG, 38025-110', 'Uberaba', 'Nossa Senhora da Abadia', 'Uberaba','MG', '38025110', -19.75673080,-47.93221930),

(nextval('hibernate_sequence'), 'Laboratório Sabin Gama', 'St. Central - Gama, Brasília - DF, 72405-901', 'Gama', 'Gama Leste', 'Brasília','DF', '72405901', -16.04959680,-48.03025410),

(nextval('hibernate_sequence'), 'Laboratório Sabin Shopping Que', 'R. 36 Norte, 05 - Águas Claras, Brasília - DF, 71900-100', 'Águas Claras', 'Norte', 'Brasília','DF', '71900100', -15.83357570,-48.03709250),

(nextval('hibernate_sequence'), 'Laboratório Sabin Asa Sul', 'Sgas 601, Conjunto A, Brasília - DF, 70200-610', 'Brasília', 'Asa Sul', 'Brasília','DF', '70200610', -15.84068890,-47.92151890),

(nextval('hibernate_sequence'), 'Laboratório Sabin Santa Maria', 'Eq 417/517/Qr 518 Conjunto O, Brasília - DF, 72548-800', 'Santa Maria', 'Santa Maria', 'Brasília','DF', '72548800', -16.01556990,-47.98526330),

(nextval('hibernate_sequence'), 'Laboratório Sabin Santa Maria Shopping', 'EQ 304/307 - Santa Maria, Brasília - DF, 72504-305', 'Santa Maria', 'Santa Maria', 'Brasília','DF', '72504305', -16.03062650,-48.02834700);

--DOADOR

INSERT INTO public.doador(
            id, celular, cidade, cpf, data_nascimento, email, jadoou, nome, 
            rg, rguf, sexo, telefone, uf)
    VALUES (nextval('hibernate_sequence'), '061984458002', 'Brasília', '00000000000', to_date('28/04/1993','DD/MM/YYYY'), 'wesley@email.com', true, 
    'Wesley Melo', 1111111,'DF','M','06133334444', 'DF');
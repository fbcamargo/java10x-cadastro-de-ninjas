-- Migrations para adicionar a coluna de RANK na tabela de dados

ALTER TABLE tb_cadastro
ADD COLUMN rank varchar(255);

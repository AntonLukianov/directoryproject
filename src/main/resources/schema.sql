CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    inn        VARCHAR(10) NOT NULL COMMENT 'ИНН',
    kpp        VARCHAR(9) NOT NULL COMMENT 'КПП',
    name       VARCHAR(64) NOT NULL COMMENT 'Сокращенное наименование организации',
    full_name   VARCHAR(128) NOT NULL COMMENT 'Полное наименование организации',
    address    VARCHAR(255) NOT NULL COMMENT 'Адрес организации',
    phone      VARCHAR(50) NOT NULL COMMENT 'Телефон организации',
    is_active   BOOLEAN COMMENT 'Действующая/ликвидированная организация'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    org_id    INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации',
    name      VARCHAR(50) NOT NULL COMMENT 'Название',
    phone     VARCHAR(50) COMMENT 'Телефон офиса',
    address   VARCHAR(255) NOT NULL COMMENT 'Адрес офиса',
    is_active BOOLEAN
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Doc (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL COMMENT 'Наименование документа',
    code        VARCHAR(50) NOT NULL COMMENT 'Код документа'
);
COMMENT ON TABLE Doc IS 'Документ';

CREATE TABLE IF NOT EXISTS Country (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(50) NOT NULL COMMENT 'Наименование страны',
    code        VARCHAR(50) NOT NULL COMMENT 'Код страны'
);
COMMENT ON TABLE Country IS 'Страна';

CREATE TABLE IF NOT EXISTS User (
    id                  INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    office_id           INTEGER NOT NULL COMMENT 'Уникальный идентификатор офиса',
    first_name          VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name         VARCHAR(50) NOT NULL COMMENT 'Фамилия',
    middle_name         VARCHAR(50) NOT NULL COMMENT 'Отчество',
    position            VARCHAR(50) NOT NULL COMMENT 'Должность',
    phone               VARCHAR(50) NOT NULL COMMENT 'Телефон человека',
    doc_id              INTEGER COMMENT 'Внешний ключ документа',
    FOREIGN KEY (doc_id) REFERENCES Doc(id),
    doc_number          VARCHAR(50) NOT NULL COMMENT 'Номер документа',
    doc_date            DATE NOT NULL COMMENT 'Дата документа',
    citizenship_id      INTEGER COMMENT 'Внешний ключ страны',
    FOREIGN KEY (citizenship_id) REFERENCES Country(id),
    is_identified       BOOLEAN
);
COMMENT ON TABLE User IS 'Человек';


CREATE INDEX Organization_Name ON Organization (name);
CREATE INDEX Organization_Id ON Organization (id);
CREATE INDEX Organization_Inn_Kpp ON Organization (inn, kpp);
CREATE INDEX Office_ID ON Office (id);
CREATE INDEX User_Fn_Sn_Mn_Pos ON User(office_id, first_name, second_name, middle_name, position);



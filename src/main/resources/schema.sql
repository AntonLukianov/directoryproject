CREATE TABLE IF NOT EXISTS Organization (
    id         INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version    INTEGER NOT NULL,
    inn        VARCHAR(10) NOT NULL COMMENT 'ИНН',
    kpp        VARCHAR(9) NOT NULL COMMENT 'КПП',
    name       VARCHAR(50) NOT NULL COMMENT 'Сокращенное наименование организации',
    full_name  VARCHAR(80) NOT NULL COMMENT 'Полное наименование организации',
    address    VARCHAR(100) NOT NULL COMMENT 'Адрес организации',
    phone      VARCHAR(25) COMMENT 'Телефон организации',
    is_active  BOOLEAN COMMENT 'Действующая/ликвидированная организация'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office (
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER NOT NULL,
    name      VARCHAR(50) NOT NULL COMMENT 'Название',
    phone     VARCHAR(25) COMMENT 'Телефон офиса',
    address   VARCHAR(100) NOT NULL COMMENT 'Адрес офиса',
    is_active BOOLEAN,
    org_id    INTEGER NOT NULL COMMENT 'Уникальный идентификатор организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Document (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(50) NOT NULL COMMENT 'Наименование документа',
    code        VARCHAR(2) NOT NULL COMMENT 'Код документа'
);
COMMENT ON TABLE Document IS 'Документ';

CREATE TABLE IF NOT EXISTS Country (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(50) NOT NULL COMMENT 'Наименование страны',
    code        VARCHAR(3) NOT NULL COMMENT 'Код страны'
);
COMMENT ON TABLE Country IS 'Страна';

CREATE TABLE IF NOT EXISTS Position (
    id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    name        VARCHAR(50) NOT NULL COMMENT 'Должность',
);
COMMENT ON TABLE Country IS 'Должность';

CREATE TABLE IF NOT EXISTS Employee (
    id                  INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version             INTEGER NOT NULL,
    first_name          VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name         VARCHAR(50) COMMENT 'Фамилия',
    middle_name         VARCHAR(50) COMMENT 'Отчество',
    phone               VARCHAR(25) COMMENT 'Телефон человека',
    is_identified       BOOLEAN COMMENT 'Статус сотрудника',
    position_id         INTEGER REFERENCES Position(id) ON DELETE NO ACTION ON UPDATE CASCADE,
    country_id          INTEGER REFERENCES Country(id) ON DELETE NO ACTION ON UPDATE CASCADE,
    office_id           INTEGER REFERENCES Office(id) ON DELETE SET NULL ON UPDATE CASCADE
);
COMMENT ON TABLE Employee IS 'Сотрудник';

CREATE TABLE IF NOT EXISTS Document_Employee (
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL,
    doc_id      INTEGER REFERENCES Document (id) ON DELETE NO ACTION ON UPDATE CASCADE,
    number      VARCHAR(30) NOT NULL UNIQUE,
    date        DATE,
    empl_id     INTEGER REFERENCES Employee (id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE INDEX IX_Office_Name ON Office (name);
CREATE INDEX IX_Office_Phone ON Office (phone);
CREATE INDEX IX_Office_Is_Active ON Office (is_active);

CREATE INDEX IX_Employee_First_Name ON Employee (first_name);
CREATE INDEX IX_Employee_Second_Name ON Employee (second_name);
CREATE INDEX IX_Employee_Middle_Name ON Employee (middle_name);

CREATE INDEX IX_Position_name ON Position (name);

CREATE INDEX IX_Organization_Name ON Organization (name);
CREATE INDEX IX_Organization_Is_Active ON Organization (is_active);



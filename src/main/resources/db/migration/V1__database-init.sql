CREATE TABLE book_bookshelves
(
    book_book_id UUID NOT NULL,
    bookshelves  VARCHAR(255)
);

CREATE TABLE book_languages
(
    book_book_id UUID NOT NULL,
    languages    VARCHAR(255)
);

CREATE TABLE book_subjects
(
    book_book_id UUID NOT NULL,
    subjects     VARCHAR(255)
);

CREATE TABLE tb_book
(
    book_id        UUID NOT NULL,
    id             INTEGER,
    title          VARCHAR(255),
    copyright      BOOLEAN,
    media_type     VARCHAR(255),
    download_count INTEGER,
    CONSTRAINT pk_tb_book PRIMARY KEY (book_id)
);

CREATE TABLE tb_book_authors
(
    book_book_id UUID NOT NULL,
    authors_id   UUID NOT NULL
);

CREATE TABLE tb_book_translators
(
    book_book_id   UUID NOT NULL,
    translators_id UUID NOT NULL
);

CREATE TABLE tb_person
(
    id         UUID NOT NULL,
    name       VARCHAR(255),
    birth_year SMALLINT,
    death_year SMALLINT,
    CONSTRAINT pk_tb_person PRIMARY KEY (id)
);

CREATE TABLE tb_result
(
    id       UUID NOT NULL,
    count    INTEGER,
    next     VARCHAR(255),
    previous VARCHAR(255),
    CONSTRAINT pk_tb_result PRIMARY KEY (id)
);

CREATE TABLE tb_result_results
(
    result_id       UUID NOT NULL,
    results_book_id UUID NOT NULL
);

ALTER TABLE tb_book_authors
    ADD CONSTRAINT uc_tb_book_authors_authors UNIQUE (authors_id);

ALTER TABLE tb_book_translators
    ADD CONSTRAINT uc_tb_book_translators_translators UNIQUE (translators_id);

ALTER TABLE tb_result_results
    ADD CONSTRAINT uc_tb_result_results_results_bookid UNIQUE (results_book_id);

ALTER TABLE book_bookshelves
    ADD CONSTRAINT fk_book_bookshelves_on_book FOREIGN KEY (book_book_id) REFERENCES tb_book (book_id);

ALTER TABLE book_languages
    ADD CONSTRAINT fk_book_languages_on_book FOREIGN KEY (book_book_id) REFERENCES tb_book (book_id);

ALTER TABLE book_subjects
    ADD CONSTRAINT fk_book_subjects_on_book FOREIGN KEY (book_book_id) REFERENCES tb_book (book_id);

ALTER TABLE tb_book_authors
    ADD CONSTRAINT fk_tbbooaut_on_book FOREIGN KEY (book_book_id) REFERENCES tb_book (book_id);

ALTER TABLE tb_book_authors
    ADD CONSTRAINT fk_tbbooaut_on_person FOREIGN KEY (authors_id) REFERENCES tb_person (id);

ALTER TABLE tb_book_translators
    ADD CONSTRAINT fk_tbbootra_on_book FOREIGN KEY (book_book_id) REFERENCES tb_book (book_id);

ALTER TABLE tb_book_translators
    ADD CONSTRAINT fk_tbbootra_on_person FOREIGN KEY (translators_id) REFERENCES tb_person (id);

ALTER TABLE tb_result_results
    ADD CONSTRAINT fk_tbresres_on_book FOREIGN KEY (results_book_id) REFERENCES tb_book (book_id);

ALTER TABLE tb_result_results
    ADD CONSTRAINT fk_tbresres_on_result FOREIGN KEY (result_id) REFERENCES tb_result (id);
CREATE SEQUENCE public.child_entity_sq INCREMENT 50 START WITH 1 MINVALUE 1;
CREATE SEQUENCE public.parent_entity_sq INCREMENT 50 START WITH 1 MINVALUE 1;


CREATE TABLE parent_entity
(
    id BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE child_entity
(
    id               BIGINT,
    field            VARCHAR NOT NULL,
    parent_entity_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (parent_entity_id) REFERENCES parent_entity (id)
);

CREATE TABLE IF NOT EXISTS decode_info
(
    id uuid NOT NULL,
    file_name CHARACTER VARYING(255),
    decoded_barcode CHARACTER VARYING(255),
    updated_at timestamp without time zone NOT NULL,
    created_at timestamp without time zone NOT NULL,
    CONSTRAINT decode_info_pkey PRIMARY KEY (id)
);
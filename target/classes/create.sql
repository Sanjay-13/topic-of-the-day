-- Table: public.topics

-- DROP TABLE public.topics;

CREATE TABLE IF NOT EXISTS public.topics
(
    id bigint NOT NULL DEFAULT nextval('topics_id_seq'::regclass),
    description character varying(255) COLLATE pg_catalog."default",
    topic_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT topics_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.topics
    OWNER to zpwwxjjabpnxzn;
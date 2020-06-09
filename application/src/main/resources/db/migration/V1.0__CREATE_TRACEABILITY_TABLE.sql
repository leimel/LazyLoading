create table Traceability
(
    id              serial primary key,
    identification  varchar(25) not null,
    transaction_date timestamp without time zone DEFAULT ('now'::text)::timestamp(6) with time zone          NOT NULL
)
;
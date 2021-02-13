
CREATE TABLE public.person (
    person_id integer NOT NULL,
    last_name character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    middle_name character varying(255),
    suffix character varying(255),
    title character varying(255),
    street_no character varying(255),
    barangay character varying(255),
    city_or_municipality character varying(255),
    zipcode integer,
    birthday date,
    grade_weighted_average double precision,
    date_hired date,
    is_currently_employed boolean
);

CREATE TABLE public.contact (
    contact_id integer NOT NULL,
    person_id integer,
    landline numeric,
    mobile_number numeric,
    email character varying(255)
);

CREATE TABLE public.role (
    role_id integer NOT NULL,
    role character varying(255)
);

CREATE TABLE public.person_role (
    person_id integer NOT NULL,
    role_id integer NOT NULL
);





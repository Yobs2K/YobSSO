CREATE TABLE users
(
    id              BIGSERIAL PRIMARY KEY,
    username        TEXT NOT NULL,
    email           TEXT NOT NULL,
    password        TEXT NOT NULL,
    name            TEXT,
    surname         TEXT,
    is_banned       BOOLEAN NOT NULL DEFAULT false,
    created_at      TIMESTAMPTZ   DEFAULT NOW(),
    updated_at      TIMESTAMPTZ   DEFAULT NOW()
);

CREATE TABLE company
(
    id              BIGSERIAL PRIMARY KEY,
    username        TEXT NOT NULL,
    name            TEXT NOT NULL,
    created_at      TIMESTAMPTZ   DEFAULT NOW(),
    updated_at      TIMESTAMPTZ   DEFAULT NOW()
);

CREATE TABLE user_to_company
(
    id              BIGSERIAL PRIMARY KEY,
    user_id         BIGSERIAL REFERENCES users (id),
    company_id      BIGSERIAL REFERENCES company (id),
    created_at      TIMESTAMPTZ   DEFAULT NOW(),
    updated_at      TIMESTAMPTZ   DEFAULT NOW()
);
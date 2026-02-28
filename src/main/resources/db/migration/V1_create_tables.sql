CREATE TABLE pelanggan
(
    id         SERIAL PRIMARY KEY,
    nama       VARCHAR(255)       NOT NULL,
    nomor_hp   VARCHAR(20) UNIQUE NOT NULL,
    total_poin INT                NOT NULL DEFAULT 0,
    created_at TIMESTAMP          NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE reward
(
    id              SERIAL PRIMARY KEY,
    nama_reward     VARCHAR(255) NOT NULL,
    poin_dibutuhkan INT          NOT NULL,
    stok            INT          NOT NULL,
    created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transaksi
(
    id              SERIAL PRIMARY KEY,
    pelanggan_id    INT            NOT NULL,
    total_belanja   DECIMAL(15, 2) NOT NULL,
    poin_didapat    INT            NOT NULL,
    jenis_transaksi VARCHAR(20)    NOT NULL,
    created_at      TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_transaksi_pelanggan
        FOREIGN KEY (pelanggan_id)
            REFERENCES pelanggan (id)
            ON DELETE CASCADE
);

CREATE TABLE penukaran_reward
(
    id             SERIAL PRIMARY KEY,
    pelanggan_id   INT       NOT NULL,
    reward_id      INT       NOT NULL,
    poin_digunakan INT       NOT NULL,
    created_at     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_penukaran_pelanggan
        FOREIGN KEY (pelanggan_id)
            REFERENCES pelanggan (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_penukaran_reward
        FOREIGN KEY (reward_id)
            REFERENCES reward (id)
            ON DELETE CASCADE
);
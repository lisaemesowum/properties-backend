
-- ------------------------
-- Table: categories
-- ------------------------
CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
-- Insert initial categories
INSERT INTO categories (name, description)
VALUES
    ('House', 'All types of houses')
ON CONFLICT (name) DO NOTHING;

INSERT INTO categories (name, description)
VALUES
    ('Apartment', 'All types of apartments')
ON CONFLICT (name) DO NOTHING;

INSERT INTO categories (name, description)
VALUES
    ('Land', 'All types of apartments')
ON CONFLICT (name) DO NOTHING;

INSERT INTO categories (name, description)
VALUES
    ('Office', 'All types of apartments')
ON CONFLICT (name) DO NOTHING;

-- ------------------------
-- Table: properties
-- ------------------------
CREATE TABLE properties (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    category_id BIGINT REFERENCES categories(id) ON DELETE SET NULL,
    price DECIMAL(15,2),
    location VARCHAR(200),
    image_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);

-- ------------------------
-- Table: contact_us
-- ------------------------
CREATE TABLE contact_us (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    message TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP DEFAULT NOW()
);
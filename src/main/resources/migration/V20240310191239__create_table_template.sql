CREATE TABLE IF NOT EXISTS public.template (
    id SERIAL PRIMARY KEY,
    template_code VARCHAR(255) NOT NULL,
    template_name VARCHAR(255) NOT NULL,
    template_description VARCHAR(255) NOT NULL,
    template_content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

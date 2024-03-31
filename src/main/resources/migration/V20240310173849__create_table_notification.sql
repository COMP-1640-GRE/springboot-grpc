CREATE TABLE IF NOT EXISTS public.notification (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    notification_type VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    url TEXT,
    seen BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    constraint fk_user_id foreign key (user_id) references public.user(id)
);


ALTER TABLE IF EXISTS public.notification DROP COLUMN IF EXISTS notification_type;
ALTER TABLE public.notification ADD COLUMN IF NOT EXISTS with_email BOOLEAN DEFAULT FALSE;


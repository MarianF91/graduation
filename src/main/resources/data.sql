-- DESTINY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES (1, 'destiny', 'You are a leader, determined and independent.'),
       (2, 'destiny', 'You are empathetic, cooperative and balanced.'),
       (3, 'destiny', 'You are creative, sociable and optimistic.'),
       (4, 'destiny', 'You are practical, stable and organized.'),
       (5, 'destiny', 'You love adventure, you are brave and adaptable.'),
       (6, 'destiny', 'You care about others, you are thoughtful and loyal.'),
       (7, 'destiny', 'You are analytic, spiritual and introspective.'),
       (8, 'destiny', 'You are a natural leader, you are ambitious and materialistic.'),
       (9, 'destiny', 'You are altruistic, idealistic and a dreamer.')
ON CONFLICT (number, type) DO NOTHING;

-- SOUL URGE NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES (1, 'soulUrge', 'You desire to be independent and in control of your destiny.'),
       (2, 'soulUrge', 'You crave harmony, balance, and close partnerships.'),
       (3, 'soulUrge', 'You long to express yourself creatively and be appreciated.'),
       (4, 'soulUrge', 'You need stability, order, and a solid foundation.'),
       (5, 'soulUrge', 'You desire freedom, change, and new experiences.'),
       (6, 'soulUrge', 'You seek responsibility, nurturing roles, and service to others.'),
       (7, 'soulUrge', 'You are drawn to introspection, knowledge, and the spiritual.'),
       (8, 'soulUrge', 'You desire material success, power, and achievement.'),
       (9, 'soulUrge', 'You are driven by compassion, generosity, and a global mission.')
ON CONFLICT (number, type) DO NOTHING;

-- PERSONALITY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES (1, 'personality', 'People see you as confident, assertive, and capable.'),
       (2, 'personality', 'You appear gentle, cooperative, and diplomatic.'),
       (3, 'personality', 'You are seen as fun, talkative, and artistic.'),
       (4, 'personality', 'You are perceived as reliable, methodical, and trustworthy.'),
       (5, 'personality', 'People see you as energetic, free-spirited, and dynamic.'),
       (6, 'personality', 'You come across as nurturing, loyal, and responsible.'),
       (7, 'personality', 'You may be seen as deep, wise, and mysterious.'),
       (8, 'personality', 'You are perceived as ambitious, strong, and authoritative.'),
       (9, 'personality', 'People see you as compassionate, idealistic, and charismatic.')
ON CONFLICT (number, type) DO NOTHING;

-- EXPRESSION NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES (1, 'expression', 'You express yourself as a bold leader, confident and original.'),
       (2, 'expression', 'You communicate with kindness, patience, and tact.'),
       (3, 'expression', 'You are expressive, cheerful, and creative in communication.'),
       (4, 'expression', 'You are practical, logical, and structured in your expression.'),
       (5, 'expression', 'You are lively, curious, and love to express through movement and change.'),
       (6, 'expression', 'You express nurturing, care, and responsibility naturally.'),
       (7, 'expression', 'You are introspective, thoughtful, and reserved in communication.'),
       (8, 'expression', 'You express ambition, authority, and strong business sense.'),
       (9, 'expression', 'You are generous, emotional, and dramatic in self-expression.')
ON CONFLICT (number, type) DO NOTHING;

-- MATURITY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES (1, 'maturity', 'In maturity, you become a confident and inspiring leader.'),
       (2, 'maturity', 'You develop harmony, diplomacy, and emotional intelligence.'),
       (3, 'maturity', 'Your creativity flourishes, and you enjoy a joyful, social life.'),
       (4, 'maturity', 'You become more grounded, responsible, and focused on stability.'),
       (5, 'maturity', 'You embrace freedom, flexibility, and diverse life experiences.'),
       (6, 'maturity', 'You find fulfillment in service, family, and community.'),
       (7, 'maturity', 'You grow spiritually and intellectually, becoming a seeker of truth.'),
       (8, 'maturity', 'You reach material success, power, and business acumen.'),
       (9, 'maturity', 'You live with compassion, purpose, and service to humanity.')
ON CONFLICT (number, type) DO NOTHING;

-- Master numbers
INSERT INTO numerology_meaning (number, type, description)
VALUES (11, 'destiny', 'You are intuitive, idealistic, and spiritually aware.'),
       (11, 'soulUrge', 'You are a visionary and deeply spiritual.'),
       (11, 'expression', 'You express higher ideals and inspiration.'),
       (11, 'maturity', 'You become a beacon of enlightenment and purpose.'),

       (22, 'destiny', 'You are a master builder, practical and visionary.'),
       (22, 'soulUrge', 'You desire to leave a lasting legacy.'),
       (22, 'expression', 'You express leadership and big-picture thinking.'),
       (22, 'maturity', 'You mature into someone who creates foundations for others.'),

       (33, 'destiny', 'You are compassionate, nurturing, and a master teacher.'),
       (33, 'soulUrge', 'You are driven by love and humanitarian causes.'),
       (33, 'expression', 'You express empathy, beauty, and truth.'),
       (33, 'maturity', 'You mature into someone who heals and inspires.')
ON CONFLICT (number, type) DO NOTHING;
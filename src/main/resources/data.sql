-- DESTINY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'DESTINY', 'You are a leader, determined and independent.'),
    (2, 'DESTINY', 'You are empathetic, cooperative and balanced.'),
    (3, 'DESTINY', 'You are creative, sociable and optimistic.'),
    (4, 'DESTINY', 'You are practical, stable and organized.'),
    (5, 'DESTINY', 'You love adventure, you are brave and adaptable.'),
    (6, 'DESTINY', 'You care about others, you are thoughtful and loyal.'),
    (7, 'DESTINY', 'You are analytic, spiritual and introspective.'),
    (8, 'DESTINY', 'You are a natural leader, you are ambitious and materialistic.'),
    (9, 'DESTINY', 'You are altruistic, idealistic and a dreamer.')
    ON CONFLICT (number, type) DO NOTHING;

-- SOUL URGE NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'SOUL_URGE', 'You desire to be independent and in control of your destiny.'),
    (2, 'SOUL_URGE', 'You crave harmony, balance, and close partnerships.'),
    (3, 'SOUL_URGE', 'You long to express yourself creatively and be appreciated.'),
    (4, 'SOUL_URGE', 'You need stability, order, and a solid foundation.'),
    (5, 'SOUL_URGE', 'You desire freedom, change, and new experiences.'),
    (6, 'SOUL_URGE', 'You seek responsibility, nurturing roles, and service to others.'),
    (7, 'SOUL_URGE', 'You are drawn to introspection, knowledge, and the spiritual.'),
    (8, 'SOUL_URGE', 'You desire material success, power, and achievement.'),
    (9, 'SOUL_URGE', 'You are driven by compassion, generosity, and a global mission.')
    ON CONFLICT (number, type) DO NOTHING;

-- PERSONALITY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'PERSONALITY', 'People see you as confident, assertive, and capable.'),
    (2, 'PERSONALITY', 'You appear gentle, cooperative, and diplomatic.'),
    (3, 'PERSONALITY', 'You are seen as fun, talkative, and artistic.'),
    (4, 'PERSONALITY', 'You are perceived as reliable, methodical, and trustworthy.'),
    (5, 'PERSONALITY', 'People see you as energetic, free-spirited, and dynamic.'),
    (6, 'PERSONALITY', 'You come across as nurturing, loyal, and responsible.'),
    (7, 'PERSONALITY', 'You may be seen as deep, wise, and mysterious.'),
    (8, 'PERSONALITY', 'You are perceived as ambitious, strong, and authoritative.'),
    (9, 'PERSONALITY', 'People see you as compassionate, idealistic, and charismatic.')
    ON CONFLICT (number, type) DO NOTHING;

-- EXPRESSION NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'EXPRESSION', 'You express yourself as a bold leader, confident and original.'),
    (2, 'EXPRESSION', 'You communicate with kindness, patience, and tact.'),
    (3, 'EXPRESSION', 'You are expressive, cheerful, and creative in communication.'),
    (4, 'EXPRESSION', 'You are practical, logical, and structured in your expression.'),
    (5, 'EXPRESSION', 'You are lively, curious, and love to express through movement and change.'),
    (6, 'EXPRESSION', 'You express nurturing, care, and responsibility naturally.'),
    (7, 'EXPRESSION', 'You are introspective, thoughtful, and reserved in communication.'),
    (8, 'EXPRESSION', 'You express ambition, authority, and strong business sense.'),
    (9, 'EXPRESSION', 'You are generous, emotional, and dramatic in self-expression.')
    ON CONFLICT (number, type) DO NOTHING;

-- MATURITY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'MATURITY', 'In maturity, you become a confident and inspiring leader.'),
    (2, 'MATURITY', 'You develop harmony, diplomacy, and emotional intelligence.'),
    (3, 'MATURITY', 'Your creativity flourishes, and you enjoy a joyful, social life.'),
    (4, 'MATURITY', 'You become more grounded, responsible, and focused on stability.'),
    (5, 'MATURITY', 'You embrace freedom, flexibility, and diverse life experiences.'),
    (6, 'MATURITY', 'You find fulfillment in service, family, and community.'),
    (7, 'MATURITY', 'You grow spiritually and intellectually, becoming a seeker of truth.'),
    (8, 'MATURITY', 'You reach material success, power, and business acumen.'),
    (9, 'MATURITY', 'You live with compassion, purpose, and service to humanity.')
    ON CONFLICT (number, type) DO NOTHING;

-- BALANCE NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'BALANCE', 'You tend to handle stress through leadership and direct action.'),
    (2, 'BALANCE', 'You seek harmony and compromise in stressful times.'),
    (3, 'BALANCE', 'You cope with challenges through creativity and humor.'),
    (4, 'BALANCE', 'You manage problems through structure, planning, and consistency.'),
    (5, 'BALANCE', 'You deal with issues by seeking freedom and change.'),
    (6, 'BALANCE', 'You find balance by helping others and creating harmony.'),
    (7, 'BALANCE', 'You turn inward and seek spiritual answers during tough times.'),
    (8, 'BALANCE', 'You assert control and rely on discipline under pressure.'),
    (9, 'BALANCE', 'You respond with compassion and empathy in crises.')
    ON CONFLICT (number, type) DO NOTHING;

-- BIRTHDAY NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'BIRTHDAY', 'You are a natural leader with strong individuality and drive.'),
    (2, 'BIRTHDAY', 'You are cooperative, considerate, and value relationships.'),
    (3, 'BIRTHDAY', 'You are expressive, optimistic, and enjoy the spotlight.'),
    (4, 'BIRTHDAY', 'You are disciplined, dependable, and practical.'),
    (5, 'BIRTHDAY', 'You are adventurous, curious, and crave variety.'),
    (6, 'BIRTHDAY', 'You are caring, responsible, and family-oriented.'),
    (7, 'BIRTHDAY', 'You are analytical, intuitive, and introspective.'),
    (8, 'BIRTHDAY', 'You are ambitious, organized, and goal-driven.'),
    (9, 'BIRTHDAY', 'You are compassionate, wise, and humanitarian.'),
    (11, 'BIRTHDAY', 'You are idealistic, intuitive, and spiritually gifted.'),
    (22, 'BIRTHDAY', 'You are a visionary with practical skills to realize big goals.')
    ON CONFLICT (number, type) DO NOTHING;

-- LESSON NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'LESSON', 'Learn to be confident, assertive, and independent.'),
    (2, 'LESSON', 'Learn patience, cooperation, and diplomacy.'),
    (3, 'LESSON', 'Learn to express yourself creatively and joyfully.'),
    (4, 'LESSON', 'Learn discipline, order, and perseverance.'),
    (5, 'LESSON', 'Learn to embrace change, freedom, and adaptability.'),
    (6, 'LESSON', 'Learn responsibility, compassion, and service to others.'),
    (7, 'LESSON', 'Learn introspection, faith, and trust in life.'),
    (8, 'LESSON', 'Learn to manage power, ambition, and material resources wisely.'),
    (9, 'LESSON', 'Learn selflessness, forgiveness, and universal love.'),
    (11, 'LESSON', 'Learn to embrace your spiritual insights and use them for the greater good.'),
    (22, 'LESSON', 'Learn to manifest large-scale dreams with grounded practicality.')
    ON CONFLICT (number, type) DO NOTHING;

-- LIFE PATH NUMBER
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (1, 'LIFE_PATH', 'You are a pioneer and leader with strong willpower.'),
    (2, 'LIFE_PATH', 'You are a peacemaker, diplomatic and sensitive.'),
    (3, 'LIFE_PATH', 'You are joyful, creative, and full of self-expression.'),
    (4, 'LIFE_PATH', 'You are hardworking, practical, and dependable.'),
    (5, 'LIFE_PATH', 'You are adventurous, freedom-loving, and dynamic.'),
    (6, 'LIFE_PATH', 'You are nurturing, responsible, and family-oriented.'),
    (7, 'LIFE_PATH', 'You are introspective, analytical, and spiritual.'),
    (8, 'LIFE_PATH', 'You are ambitious, organized, and business-minded.'),
    (9, 'LIFE_PATH', 'You are compassionate, idealistic, and philanthropic.'),
    (11, 'LIFE_PATH', 'You are an inspired visionary with strong intuition and purpose.'),
    (22, 'LIFE_PATH', 'You are a master builder with great potential to uplift humanity.')
    ON CONFLICT (number, type) DO NOTHING;

-- MASTER NUMBERS
INSERT INTO numerology_meaning (number, type, description)
VALUES
    (11, 'DESTINY', 'You are intuitive, idealistic, and spiritually aware.'),
    (11, 'SOUL_URGE', 'You are a visionary and deeply spiritual.'),
    (11, 'EXPRESSION', 'You express higher ideals and inspiration.'),
    (11, 'MATURITY', 'You become a beacon of enlightenment and purpose.'),

    (22, 'DESTINY', 'You are a master builder, practical and visionary.'),
    (22, 'SOUL_URGE', 'You desire to leave a lasting legacy.'),
    (22, 'EXPRESSION', 'You express leadership and big-picture thinking.'),
    (22, 'MATURITY', 'You mature into someone who creates foundations for others.'),

    (33, 'DESTINY', 'You are compassionate, nurturing, and a master teacher.'),
    (33, 'SOUL_URGE', 'You are driven by love and humanitarian causes.'),
    (33, 'EXPRESSION', 'You express empathy, beauty, and truth.'),
    (33, 'MATURITY', 'You mature into someone who heals and inspires.')
    ON CONFLICT (number, type) DO NOTHING;
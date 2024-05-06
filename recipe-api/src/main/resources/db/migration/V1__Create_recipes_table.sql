CREATE TABLE recipes (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name CHAR(60)            NOT NULL,
    ingredients VARCHAR(300) NOT NULL,
    difficulty CHAR(15)      NOT NULL,
    dietary_restrictions CHAR(50)
);

INSERT INTO recipes (name, ingredients, difficulty, dietary_restrictions)
VALUES
    ('Avacado Toast with Egg', 'bread, avacado, egg, salt, pepper', 'easy', 'vegetarian'),
    ('Avacado Toast', 'bread, avacado, salt, pepper', 'easy', 'vegetarian, vegan'),
    ('Porridge', 'Oats', 'easy', 'vegetarian, vegan, gluten free'),
    ('Cereal', 'cereal, milk', 'easy', 'vegetarian'),
    ('Chicken Noodle Soup', 'pasta, chicken broth, chicken breast, carrots, onion, salt, pepper', 'easy', ''),
    ('Cheese Quesadilla', 'flour tortilla, shredded cheese', 'easy', ''),
    ('GF Cheese Quesadilla', 'corn tortilla, shredded cheese', 'easy', 'gluten free'),
    ('Baked Potato', 'potato, butter, shredded cheese, oil, salt, pepper', 'easy', 'gluten free, vegetarian'),
    ('Pasta with Cheese', 'pasta, shredded cheese', 'easy', 'vegetarian'),
    ('Deviled Eggs', 'egg, mayonnaise, mustard', 'easy', 'vegetarian'),
    ('Yorkshire Pudding', 'flour, eggs, milk, oil', 'easy', 'vegetarian'),
    ('Prawn Cocktail', 'prawns, mayonnaise, ketchup, worcestershire sauce, lemon juice, avacado, paprika, salt, pepper', 'easy', ''),
    ('Shrimp Cocktail', 'Shrimp, mayonnaise, ketchup, worcestershire sauce, lemon juice, salt, pepper, hot sauce, horseradish', 'easy', ''),
    ('Mashed Potatoes', 'Potato, salt, butter', 'easy', 'vegetarian, gluten free'),
    ('Chili Con Carne', 'ground beef, tomatoes, onion, garlic, oil, chili powder, cayenne pepper, garlic powder, onion, salt, pepper', 'medium', 'gluten free'),
    ('Meat Sauce', 'Ground beef, tomatoes, onion, garlic, oil, garlic powder, onion powder, salt, pepper', 'medium', 'gluten free'),
    ('Burrito Bowl', 'Rice, beans, corn, chicken breast, oil, avacado, salsa, salt, pepper, paprika, garlic powder, chili powder', 'medium', 'gluten free'),
    ('Pasta with Meatballs', 'Ground beef, milk, egg, salt, pepper, onion powder, garlic powder, pasta, oil', 'medium', ''),
    ('Fried Rice', 'Rice, corn, carrots, peas, onion, salt, pepper, white pepper, onion powder, garlic powder, soy sauce, oil', 'medium', 'vegetarian, vegan'),
    ('Bean Curry', 'oil, onion, garlic, ginger, coriander, cumin, paprika, garam masala, tomato, beans, rice', 'medium', 'vegetarian, vegan'),
    ('Roasted Chicken', 'Onion, carrot, whole chicken, lemon, butter', 'advanced', 'gluten free'),
    ('Fried Pork Chops', 'Pork chops, flour, salt, pepper, cayenne pepper, oil, butter', 'advanced', ''),
    ('Chicken Tikka Masala', 'chicken thighs, yogurt, garlic, ginger, garam masala, tumeric, cumin, chili powder, salt, oil, butter, onion, coriander, tomato puree, double cream, sugar', 'advanced', 'gluten free'),
    ('Keema Aloo', 'ground beef, potato, oil, onion, garlic, ginger, tomato, salt, coriander, cumin, chili powder, garam masala, paprika, pepper', 'advanced', 'gluten free');

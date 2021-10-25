# ABN AMRO Practical Full‐stack Assignment (BE)
## Objective

Create a single‐page web application which allows users to manage your favourite recipes.
Use a dashboard to show all available recipes and the actions to create, update and delete a recipe.
When the user selects a recipe the application should display on the same screen the following attributes:
- [x] Date and time of creation (formatted as dd‐MM‐yyyy HH:mm);
- [x] Indicator if the dish is vegetarian;
- [x] Indicator displaying the number of people the dish is suitable for;
- [x] Display ingredients as a list;
- [x] Cooking instructions;

## Design decision
1. Data can be stored as key-value pair , from an API prospective key-value pair are very NonSQL data stores so have choosen the MongoDB
2. Simple Spring API with persistance model for persitance layer
3. Angular UI aplication
4. Docker has choosen the right container to prepare the image and run on container
## Steps can be followed to run on local 
1. Install the Docker desktop which intern contain Docker enginer and Docker compose
2. To make sure code is compiled and build run the docker-compose build (-d in case if want to run at backgroud)
3. To compose/run the container image run the docker-compose up (-d in case if want to run at backgroud)
4. To force build while run running to consider the recent changes docker-compose up --build (Force build)
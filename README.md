# Futbol 5 app
## Estructura
### models 
En Models principalmente se aloja la clase team y la clase persona, de ahi se extienden hacia jugadores, con una ficha tecnica y estadisticas, y entrenadores

### Controllers
En App se llama a MainMenuController, donde se encuentra la logica para guardar, cargar y eliminar equipos, en TeamController se llama a los modelos de jugadores y entrenadores para cargarlos en un equipo especifico, luego tenemos controladores para leer y escribir CSVs, donde se tomaran todos los datos de los equipos y sus jugadores, y se cargaran al csv o se traeran estos datos. 

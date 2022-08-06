##Despliegue de apps Laptop con Spring Boot en Heroku

Crear archivo 'system.properties' en el proyecto con el contenido:

```
java.runtime.version=poner version 17 o 18 o la que sea
```

1. Contar con una cuenta en Heroku
2. Tener configurado git en la computadora
    a- `git config --global user.name """`
    b- `git config --global user.email nn@ex.com`
3. Subir el proyecto a GitHub de Intellij opcion VCS> Share project en GitHub
4. Desde Heroku, crear app u elegir metodo GitHub y buscar el repositorio que subimos
5. Habilitar deploy automatico y ejecutar el Deploy
 curl -H 'Content-Type: application/json' -X POST localhost:8080/api/platillo -d '
 {
     "nombre": "Pollo Frito", 
     "descripcion": "Frito y con papas", 
     "precio": 89.90,
     "vegetariano": false,
     "disponible": true
 }' | jq


curl -H 'Content-Type: application/json' -X POST localhost:8080/api/platillo -d '
{
    "nombre": "Enchiladas",
    "descripcion": "Verdes o rojas con queso y pollo", 
    "precio": 89.90,
    "vegetariano": false,
    "disponible": true
}' | jq

curl -H 'Content-Type: application/json' -X POST localhost:8080/api/orden -d '
{
    "nombreCliente": "Juan", 
    "notasDeOrden": "Sin queso", 
    "platillos": ["Enchiladas", "Pollo Frito"]
}' | jq

curl -H 'Content-Type: application/json' -X GET localhost:8080/api/orden | jq


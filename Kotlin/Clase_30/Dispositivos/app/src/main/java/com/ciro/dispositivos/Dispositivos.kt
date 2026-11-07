package com.ciro.dispositivos

// Modelo de un dispositivo; las propiedades se declaran directamente en el constructor.
// data es de tipo Specs, así que un objeto puede contener a otro.
data class Dispositivos(val id: Long, val name: String, val data: Specs)
// JSON de ejemplo con la forma de los datos que el modelo representa.
// "data": null y las claves distintas entre objetos muestran por qué las propiedades de Specs son nullables.
/*
[
  {
    "id": "1",
    "name": "Google Pixel 6 Pro",
    "data": {
      "color": "Cloudy White",
      "capacity": "128 GB"
    }
  },
  {
    "id": "2",
    "name": "Apple iPhone 12 Mini, 256GB, Blue",
    "data": null
  },
  {
    "id": "3",
    "name": "Apple iPhone 12 Pro Max",
    "data": {
      "color": "Cloudy White",
      "capacity GB": 512
    }
  },
  {
    "id": "4",
    "name": "Apple iPhone 11, 64GB",
    "data": {
      "price": 389.99,
      "color": "Purple"
    }
  },
  {
    "id": "5",
    "name": "Samsung Galaxy Z Fold2",
    "data": {
      "price": 689.99,
      "color": "Brown"
    }
  },
  {
    "id": "6",
    "name": "Apple AirPods",
    "data": {
      "generation": "3rd",
      "price": 120
    }
  },
  {
    "id": "7",
    "name": "Apple MacBook Pro 16",
    "data": {
      "year": 2019,
      "price": 1849.99,
      "CPU model": "Intel Core i9",
      "Hard disk size": "1 TB"
    }
  },
  {
    "id": "8",
    "name": "Apple Watch Series 8",
    "data": {
      "Strap Colour": "Elderberry",
      "Case Size": "41mm"
    }
  },
  {
    "id": "9",
    "name": "Beats Studio3 Wireless",
    "data": {
      "Color": "Red",
      "Description": "High-performance wireless noise cancelling headphones"
    }
  },
  {
    "id": "10",
    "name": "Apple iPad Mini 5th Gen",
    "data": {
      "Capacity": "64 GB",
      "Screen size": 7.9
    }
  },
  {
    "id": "11",
    "name": "Apple iPad Mini 5th Gen",
    "data": {
      "Capacity": "254 GB",
      "Screen size": 7.9
    }
  },
  {
    "id": "12",
    "name": "Apple iPad Air",
    "data": {
      "Generation": "4th",
      "Price": "419.99",
      "Capacity": "64 GB"
    }
  },
  {
    "id": "13",
    "name": "Apple iPad Air",
    "data": {
      "Generation": "4th",
      "Price": "519.99",
      "Capacity": "256 GB"
    }
  }
]
 */

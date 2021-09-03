import requests
import json
import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="paulo",
  password="admin",
  database="starB2W",
  auth_plugin="mysql_native_passoword"
)
table = "planets"
mycursor = mydb.cursor()
def save (table, id, name, climate, terrain):
    sql = "INSERT INTO " + table + "(id, name, climate, terrain) VALUES (%s, %s, %s, %s)"
    val = (id, name, climate, terrain)
    mycursor.execute(sql,val)
    mydb.commit()

response = requests.get('https://swapi.dev/api/planets/')
numberOfPlanets = json.loads(response.text)['count']

i = 0
while i < numberOfPlanets:
    id = (i+1)
    response = requests.get('https://swapi.dev/api/planets/' + str(id))

    body = json.loads(response.text)
    name = body['name']
    climate = body['climate']
    terrain = body['terrain']
    print("id " + str(id), "name: " + name, "climate: " + climate, "terrain: " + terrain)
    save(table, id, name, climate, terrain)
    i = i + 1
mydb.close()


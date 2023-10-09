import jwt
import datetime
import os

payload = {
    'username': "sechung",
    'exp': datetime.datetime.utcnow() + datetime.timedelta(minutes=1)
}
token = jwt.encode(payload, "myforum", algorithm='HS256')
print(token, end="///")
print()
print("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6InNlY2h1bmciLCJleHAiOjE2OTA0NTgwMDJ9.sKvmNgq89GUjNqfVqN2yLi2D6xgjYDjrs6Uo7xO2bss")
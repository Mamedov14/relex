# relax

### Все найденные числа/последовательности из тестового файла 10m.txt

+ **max_value** = 49999978
+ **min_value** = -49999996
+ **median_value** = 25216
+ **avg_value** = 7364.418442641844
+ **asc_sequence** = -48190694, -47725447, -43038241, -20190291, -17190728, -6172572, 8475960, 25205909, 48332507, 48676185
+ **desc_sequence** = 47689379, 42381213, 30043880, 12102356, -4774057, -5157723, -11217378, -23005285, -23016933, -39209115, -49148762

### Примеры REST-запросов и ответов

## Пример №1
```json
GET http://localhost:8080/relex/get_max_value
request:
{
    "filepath": "F:\\company\\internship_relex\\myFile.txt"
}
response:
{
    "max_value": 23453242
}
```

## Пример №2
```json
GET http://localhost:8080/relex/get_avg_value
request:
{
    "filepath": "F:\\company\\internship_relex\\myFile.txt"
}
response:
{
    "avg_value": 819062.9189189189
}
```

## Пример №3
```json
GET http://localhost:8080/relex/
request:
{
    "filepath": "F:\\company\\internship_relex\\myFile.txt",
    "operation": "get_median_value"
}
response:
{
    "median_value": 67
}
```

## Пример №4
```json
GET http://localhost:8080/relex/
request:
{
    "filepath": "F:\\company\\internship_relex\\myFile.txt",
    "operation": "get_asc_sequence"
}
response:
{
    "asc_sequence": [
      [
        65,
        346,
        435,
        652
      ]
    ]
}
```


## Пример №5
```json
GET http://localhost:8080/relex/get_desc_sequence
request:
{
    "filepath": "F:\\company\\internship_relex\\myFile.txt"
}
response:
{
    "desc_sequence": [
      [
        23453242,
        6758768,
        345,
        125,
        45
      ],
      [
        78,
        76,
        74,
        35,
        2
      ]
    ]
}
```

## Пример №6
```json
GET http://localhost:8080/relex/
request:
{
    "filepath": "F:\\company\\internship_relex\\10m.txt",
    "operation": "get_min_value"
}
response:
{
    "min_value": -49999996
}
```

## Пример №7
```json
GET http://localhost:8080/relex/get_asc_sequence
request:
{
    "filepath": "F:\\company\\internship_relex\\10m.txt"
}
response:
{
    "asc_sequence": [
      [
        -48190694,
        -47725447,
        -43038241,
        -20190291,
        -17190728,
        -6172572,
        8475960,
        25205909,
        48332507,
        48676185
      ]
    ]
}
```


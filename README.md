# quality-challenge
Desafio Quality seguindo o acrônimo SOLID no módulo sobre testes e qualidade de software no Bootcamp MeLi

## Como rodar o projeto
1. Clonar o projeto
```
git@github.com:nyvieirameli/quality-challenge.git
```
2. Rodar o projeto pelo IntelliJ IDEA.

## Documentação completa
Para uma visão de todas as chamadas disponíveis para uso, acesse a documentação completa através do link: https://documenter.getpostman.com/view/15849644/TzeUn8Pi

## Collection de exemplo
Uma collection do postman está disponível para aulixiar em teste e em exemplos.
Para cloná-la, vá ao site https://www.postman.com/ ou abra seu aplicativo e importe o seguinte link:
```
https://www.getpostman.com/collections/75751f56f60507922b0f
```

## Use Cases

### Todas as USs
Todas as USs podem ser testadas através de um único endpoint (informado abaixo) com um retorno completo, as outras chamadas possuem o mesmo corpo de requisição, com corpos de resposta diferentes.

```
POST /calculate/area
```

| Parâmetro | Tipo | Descrição |
| ----------- | ---- | --------- |
| name | String | Nome da propriedade |
| neighborhood | String | Nome do bairro |
| rooms | List | Lista de quartos de uma propriedade  |
| name | String | Nome do quarto  |
| width| Double | Comprimento do quarto  |
| height | Double | Largura do quarto  |

Exemplo de Json de envio:
````json
{
  "name":"Casa",
  "neighborhood":"Veloso",
  "rooms":[
    {
      "name":"Quintal",
      "width":10.00,
      "height":10.0
    },
    {
      "name":"Banheiro",
      "width":2.5,
      "height":2.5
    },
    {
      "name":"Cozinha",
      "width":5.0,
      "height":5.0
    }
  ]
}
````

Retorno:
| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao calcular e criar o objeto |
| 400 | BAD REQUEST | Dados da requisição errados |
| 404 | NOT FOUND | Caso bairro não seja válido |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "timestamp": 1623687717782,
  "hasError": false,
  "errorMessage": null,
  "data": {
    "name": "Casa",
    "neighborhood": "Veloso",
    "totalArea": 131.25,
    "totalPrice": 393750.0,
    "roomsQuantity": 3,
    "rooms": [
      {
        "name": "Banheiro",
        "area": 6.25,
        "price": 18750.0
      },
      {
        "name": "Cozinha",
        "area": 25.0,
        "price": 75000.0
      },
      {
        "name": "Quintal",
        "area": 100.0,
        "price": 300000.0
      }
    ]
  }
}
```

Exemplo de Json de Retorno Em Caso De Erro 400:
````json
{
  "timestamp": 1623687754664,
  "hasError": true,
  "errorMessage": "The property name must start with uppercase char",
  "data": null
}
````

Exemplo de Json de Retorno Em Caso De Erro 404:
````json
{
  "timestamp": 1623688229143,
  "hasError": true,
  "errorMessage": "Neighborhood not found",
  "data": null
}
````

### US001 - Calcule o total de metros quadrados de uma propriedade

```
POST /calculate/total-area
```

| Parâmetro | Tipo | Descrição |
| ----------- | ---- | --------- |
| name | String | Nome da propriedade |
| neighborhood | String | Nome do bairro |
| rooms | List | Lista de quartos de uma propriedade  |
| name | String | Nome do quarto  |
| width| Double | Comprimento do quarto  |
| height | Double | Largura do quarto  |

Exemplo de Json de envio:
````json
{
  "name":"Casa",
  "neighborhood":"Veloso",
  "rooms":[
    {
      "name":"Quintal",
      "width":10.00,
      "height":10.0
    },
    {
      "name":"Banheiro",
      "width":2.5,
      "height":2.5
    },
    {
      "name":"Cozinha",
      "width":5.0,
      "height":5.0
    }
  ]
}
````

Retorno:
| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao calcular a área total |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Caso bairro não seja válido |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "timestamp": 1623687988756,
  "hasError": false,
  "errorMessage": null,
  "data": 131.25
}
```

Exemplo de Json de Retorno Em Caso De Erro 400:
````json
{
  "timestamp": 1623688025554,
  "hasError": true,
  "errorMessage": "The biggest size for a room is 25m of width and 33 of height",
  "data": null
}
````

Exemplo de Json de Retorno Em Caso De Erro 404:
````json
{
  "timestamp": 1623688229143,
  "hasError": true,
  "errorMessage": "Neighborhood not found",
  "data": null
}
````

### US002 - Indica o valor de uma propriedade com base em seus quartos e medidas. Lembre-se que os preços por metro quadrado são determinados de acordo com o bairro.

```
POST /calculate/total-price
```

| Parâmetro | Tipo | Descrição |
| ----------- | ---- | --------- |
| name | String | Nome da propriedade |
| neighborhood | String | Nome do bairro |
| rooms | List | Lista de quartos de uma propriedade  |
| name | String | Nome do quarto  |
| width| Double | Comprimento do quarto  |
| height | Double | Largura do quarto  |

Exemplo de Json de envio:
````json
{
  "name":"Casa",
  "neighborhood":"Veloso",
  "rooms":[
    {
      "name":"Quintal",
      "width":10.00,
      "height":10.0
    },
    {
      "name":"Banheiro",
      "width":2.5,
      "height":2.5
    },
    {
      "name":"Cozinha",
      "width":5.0,
      "height":5.0
    }
  ]
}
````

Retorno:
| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao calcular a área total |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Caso bairro não seja válido |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "timestamp": 1623688489008,
  "hasError": false,
  "errorMessage": null,
  "data": 393750.0
}
```

Exemplo de Json de Retorno Em Caso De Erro 400:
````json
{
  "timestamp": 1623688025554,
  "hasError": true,
  "errorMessage": "The biggest size for a room is 25m of width and 33 of height",
  "data": null
}
````

Exemplo de Json de Retorno Em Caso De Erro 404:
````json
{
  "timestamp": 1623688229143,
  "hasError": true,
  "errorMessage": "Neighborhood not found",
  "data": null
}
````

### US003 - Determine qual é a maior sala

```
POST /calculate/biggestRoom
```

| Parâmetro | Tipo | Descrição |
| ----------- | ---- | --------- |
| name | String | Nome da propriedade |
| neighborhood | String | Nome do bairro |
| rooms | List | Lista de quartos de uma propriedade  |
| name | String | Nome do quarto  |
| width| Double | Comprimento do quarto  |
| height | Double | Largura do quarto  |

Exemplo de Json de envio:
````json
{
  "name":"Casa",
  "neighborhood":"Veloso",
  "rooms":[
    {
      "name":"Quintal",
      "width":10.00,
      "height":10.0
    },
    {
      "name":"Banheiro",
      "width":2.5,
      "height":2.5
    },
    {
      "name":"Cozinha",
      "width":5.0,
      "height":5.0
    }
  ]
}
````

Retorno:
| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao calcular a área total |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Caso bairro não seja válido |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "timestamp": 1623688552830,
  "hasError": false,
  "errorMessage": null,
  "data": {
    "name": "Quintal",
    "area": 100.0,
    "price": 300000.0
  }
}
```

Exemplo de Json de Retorno Em Caso De Erro 400:
````json
{
  "timestamp": 1623688025554,
  "hasError": true,
  "errorMessage": "The biggest size for a room is 25m of width and 33 of height",
  "data": null
}
````

Exemplo de Json de Retorno Em Caso De Erro 404:
````json
{
  "timestamp": 1623688229143,
  "hasError": true,
  "errorMessage": "Neighborhood not found",
  "data": null
}
````

### US004 - Determine o número de metros quadrados que cada cômodo possui

```
POST /calculate/rooms
```

| Parâmetro | Tipo | Descrição |
| ----------- | ---- | --------- |
| name | String | Nome da propriedade |
| neighborhood | String | Nome do bairro |
| rooms | List | Lista de quartos de uma propriedade  |
| name | String | Nome do quarto  |
| width| Double | Comprimento do quarto  |
| height | Double | Largura do quarto  |

Exemplo de Json de envio:
````json
{
  "name":"Casa",
  "neighborhood":"Veloso",
  "rooms":[
    {
      "name":"Quintal",
      "width":10.00,
      "height":10.0
    },
    {
      "name":"Banheiro",
      "width":2.5,
      "height":2.5
    },
    {
      "name":"Cozinha",
      "width":5.0,
      "height":5.0
    }
  ]
}
````

Retorno:
| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Sucesso ao calcular a área total |
| 400 | BAD REQUEST | Dados da Requisição errados |
| 404 | NOT FOUND | Caso bairro não seja válido |

Exemplo de Json Em Caso de Sucesso:
```json
{
  "timestamp": 1623688193960,
  "hasError": false,
  "errorMessage": null,
  "data": [
    {
      "name": "Banheiro",
      "area": 6.25,
      "price": 18750.0
    },
    {
      "name": "Cozinha",
      "area": 25.0,
      "price": 75000.0
    },
    {
      "name": "Quintal",
      "area": 100.0,
      "price": 300000.0
    }
  ]
}
```

Exemplo de Json de Retorno Em Caso De Erro 400:
````json
{
  "timestamp": 1623688025554,
  "hasError": true,
  "errorMessage": "The biggest size for a room is 25m of width and 33 of height",
  "data": null
}
````

Exemplo de Json de Retorno Em Caso De Erro 404:
````json
{
  "timestamp": 1623688229143,
  "hasError": true,
  "errorMessage": "Neighborhood not found",
  "data": null
}
````

## Testes integrados

Os testes integrados foram feitos baseados em retornos corretos (OK ou 200) na classe CalculatorServiceImplSprintTest, pois ele possui integração com o NeighborhoodRepository

## Testes unitários

### Teste 1: Verifique se o total de metros quadrados calculados por propriedade está correto.

Classe "CalculatorServiceImplTest", teste "shouldCalculateTotalAreaCorrectly"

```java
public class CalculatorServiceImplTest {

    @Mock
    private NeighborhoodRepository repository;
    private CalculatorServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CalculatorServiceImpl(repository);
    }

    @Test
    public void shouldCalculateTotalAreaCorrectly() {
        var responseExpected = 200.0;

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var response = service.calculateTotalArea(roomsRequest);

        assertThat(response).isEqualTo(responseExpected);
    }

    private ArrayList<RoomRequestDTO> createRoomsRequest(String name1, String name2, Double width, Double height) {
        var rooms = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO(name1, width, height),
                        new RoomRequestDTO(name2, width, height)
                )
        );
        return rooms;
    }
}
```

### Teste 2: Verifique se o bairro de entrada existe no repositório de bairros.

Classe "NeighborhoodRepositoryTest", teste "shouldReturnCorrectNeighborhoodByName" caso esteja correto e teste "shouldReturnNotFoundExceptionWithFakeName" caso não exista

```java
public class NeighborhoodRepositoryTest {

    NeighborhoodRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new NeighborhoodRepositoryImpl();
    }

    @Test
    public void shouldReturnCorrectNeighborhoodByName() {
        var responseExpected = new NeighborhoodDTO("Veloso", 3000.0);

        var response = repository.getByName("Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }
    
    @Test
    public void shouldReturnNotFoundExceptionWithFakeName() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.getByName("Teste");
        });
    }
}
```

### Teste 3: Verifique se a maior sala foi realmente devolvida.

Classe "CalculatorServiceImplTest", teste "shouldGetBiggestRoomCorrectly"

```java
public class CalculatorServiceImplTest {

    @Mock
    private NeighborhoodRepository repository;
    private CalculatorServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CalculatorServiceImpl(repository);
    }

    @Test
    public void shouldGetBiggestRoomCorrectly() {
        var responseExpected = new RoomResponseDTO("Quintal2", 100.0, 300000.0);

        when(repository.getAreaPriceByName("Veloso")).thenReturn(3000.00);

        var roomsRequest = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO("Quintal1", 5.0, 5.0),
                        new RoomRequestDTO("Quintal2", 10.0, 10.0),
                        new RoomRequestDTO("Quintal3", 7.0, 7.0)
                )
        );
        var response = service.getTheBiggestRoom(roomsRequest, "Veloso");

        verify(repository, atLeast(1)).getAreaPriceByName("Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }
}
```

### Teste 4: Verifique se de fato o total de metros quadrados por cômodo está correto.

Classe "CalculatorServiceImplTest", teste "shouldCalculateRoomsRequestCorrectly"

```java
public class CalculatorServiceImplTest {

    @Mock
    private NeighborhoodRepository repository;
    private CalculatorServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new CalculatorServiceImpl(repository);
    }

    @Test
    public void shouldCalculateRoomsRequestCorrectly() {
        var responseExpected = createExpectedRoomsResponse();

        when(repository.getAreaPriceByName("Veloso")).thenReturn(3000.00);

        var roomsRequest = createRoomsRequest("Quintal1", "Quintal2", 10.0, 10.0);
        var response = service.calculateRoomsResponse(roomsRequest, "Veloso");

        verify(repository, atLeast(1)).getAreaPriceByName("Veloso");

        assertThat(response.toString()).isEqualTo(responseExpected.toString());
    }

    private ArrayList<RoomRequestDTO> createRoomsRequest(String name1, String name2, Double width, Double height) {
        var rooms = new ArrayList<>(
                Arrays.asList(
                        new RoomRequestDTO(name1, width, height),
                        new RoomRequestDTO(name2, width, height)
                )
        );
        return rooms;
    }

    private ArrayList<RoomResponseDTO> createExpectedRoomsResponse() {
        var roomsExpected = new ArrayList<>(
                Arrays.asList(
                        new RoomResponseDTO("Quintal1", 100.0, 300000.0),
                        new RoomResponseDTO("Quintal2", 100.0, 300000.0)
                )
        );
        return roomsExpected;
    }
}
```
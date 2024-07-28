## Santader dev week 2023
Java Restful API criada para o curso desenvolvimento Java com IA

## Diagrama de classes

```mermaid
classDiagram
    class User {
        +String name
        +Account account
        +List<Feature> features
        +Card card
        +List<News> news
    }

    class Account {
        +String number
        +String agency
        +Float balance
        +Float limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +Float limit
    }

    class News {
        +String icon
        +String description
    }

    User "1" *--> "1" Account
    User "1" *--> "N" Feature
    User "1" *--> "N" Card
    User "1" *--> "N" News
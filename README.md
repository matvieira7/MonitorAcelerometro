
# Monitor de Acelerômetro

Aplicativo Android desenvolvido em Java que utiliza o sensor acelerômetro do dispositivo para monitorar e exibir os valores de aceleração nos eixos X, Y e Z em tempo real.

## Objetivo

Demonstrar a utilização de sensores disponíveis em dispositivos Android, permitindo visualizar as variações de aceleração conforme o aparelho é movimentado ou inclinado.

## Funcionalidades

- Identificação da disponibilidade do acelerômetro.
- Leitura dos valores dos eixos X, Y e Z.
- Exibição dos dados em tempo real.
- Atualização automática das informações durante a movimentação do dispositivo.

## Tecnologias utilizadas

- Java
- Android Studio
- XML
- Android Sensor Framework

## Sensor utilizado

O projeto utiliza o acelerômetro, sensor responsável por medir a aceleração aplicada ao dispositivo nos três eixos:

- **Eixo X:** movimento lateral.
- **Eixo Y:** movimento vertical.
- **Eixo Z:** movimento de profundidade.

Os valores são apresentados em metros por segundo ao quadrado (m/s²). A leitura também considera a influência da gravidade.

## Como executar

1. Clone este repositório:

   ```bash
   git clone https://github.com/matvieira7/MonitorAcelerometro.git
   ```

2. Abra o projeto no Android Studio.
3. Aguarde a sincronização do Gradle.
4. Conecte um dispositivo Android ou inicie um emulador compatível.
5. Execute o aplicativo pelo botão **Run**.

## Estrutura do projeto

```text
MonitorAcelerometro/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/monitoracelerometro/
│           │       └── MainActivity.java
│           ├── res/
│           │   └── layout/
│           │       └── activity_main.xml
│           └── AndroidManifest.xml
└── README.md
```

## Autor

Matheus

## Repositório

https://github.com/matvieira7/MonitorAcelerometro

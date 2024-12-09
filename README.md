
# 📍 **Lembretes de Localização**  

## 📘 **Descrição do Projeto**  
O **Lembretes de Localização** é um aplicativo Android desenvolvido para permitir que usuários criem lembretes baseados em locais específicos. Utilizando o Google Maps, Geofencing, Firebase Authentication e armazenamento local, o aplicativo oferece funcionalidades intuitivas para criar, visualizar e receber notificações quando o usuário entra em uma área específica.

---

## 🚀 **Funcionalidades Principais**  

### 1. **Autenticação do Usuário**  
- **Login:** Tela de login para autenticação via e-mail ou conta Google.  
- **Cadastro:** Tela de cadastro para criação de uma nova conta.  
- **Firebase Authentication:** Utilização do **FirebaseUI-Android** para implementação.  
- **Logout:** Permite que o usuário saia do aplicativo, exigindo login ao reiniciar.  

---

### 2. **Mapa e POIs**  
- **Visualização do Mapa:** Mostra a localização atual do usuário (com permissão).  
- **POI (Pontos de Interesse):** O usuário seleciona um local no mapa para adicionar um lembrete.  
- **Geofencing:** Gera uma cerca geográfica (raio circular) para o POI selecionado.  
- **Estilo do Mapa:** Personalização do estilo do mapa usando o Google Maps Style API.  
- **Alteração do Tipo de Mapa:** Opções para alternar entre tipos de mapa (Satélite, Híbrido, etc.).  

---

### 3. **Gerenciamento de Lembretes**  
- **Criar Lembretes:** Tela para adicionar um lembrete com:  
   - Título  
   - Descrição  
   - Local Selecionado  
- **Lista de Lembretes:** Exibe todos os lembretes armazenados localmente.  
- **Notificações:** Quando o usuário entra na área geográfica do lembrete, uma **notificação** é enviada mesmo que o app esteja em segundo plano.  
- **Exibição de Detalhes:** Ao clicar na notificação, uma nova tela exibe os detalhes do lembrete.  

---

### 4. **Testes**  
- **MVVM e Injeção de Dependência:** Arquitetura MVVM implementada com **Koin**.  
- **Testes Unitários e Instrumentados:**  
   - **ViewModels e LiveData:** Testados com **FakeDataSource** e cobertura de erros.  
   - **UI Tests:** Utilização do **Espresso** e **Mockito** para validar interações e navegação.  
   - **DAO e Repository:** Testes usando **Room.inMemoryDatabaseBuilder**.  

---

## 🛠️ **Tecnologias Utilizadas**  

- **Linguagem:** Kotlin  
- **Frameworks e Bibliotecas:**  
   - Firebase Authentication & FirebaseUI  
   - Google Maps API & Geofencing API  
   - Jetpack Components (ViewModel, LiveData, Room)  
   - Koin (Injeção de Dependência)  
   - Coroutines  
   - Mockito e Espresso (Testes)  
---

## 📱 **Instalação e Execução**  

### Pré-requisitos  
- **Android Studio** (versão mais recente)  
- **Google Maps API Key**  
- **Firebase Project** configurado.  

### Passos  
1. Clone o repositório:  
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```  
2. Adicione a API Key no arquivo `local.properties`:  
   ```properties
   MAPS_API_KEY=YOUR_API_KEY
   ```  
3. Configure o Firebase no projeto.  
4. Compile e execute o aplicativo no Android Studio.

---

## 📝 **Observações Importantes**  

- O app é compatível com todas as versões do Android até o **Android Q**.  
- Permissões de localização são solicitadas em tempo de execução.  
- Implementação segue boas práticas de **MVVM** e injeção de dependência com **Koin**.  
- O projeto inclui cobertura de testes de unidades e testes instrumentados.  

---

## 📋 **Requisitos Atendidos**  

✅ Autenticação com FirebaseUI  
✅ Gerenciamento de Lembretes com Geofencing  
✅ Visualização de mapa com Google Maps API  
✅ Arquitetura MVVM com testes unitários e instrumentados  
✅ Notificações em segundo plano  
 

---

## 🤝 **Contato**  

Caso tenha dúvidas ou sugestões:  
- **Email:** amandakellensoares@hotmail.com
- **LinkedIn:** [[Seu LinkedIn]](https://www.linkedin.com/in/amanda-kellen/)  

---

**© 2024 - Projeto desenvolvido como parte do curso Udacity.**  

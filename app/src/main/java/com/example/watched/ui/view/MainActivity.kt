package com.example.watched.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridCells.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.watched.ui.theme.WatchedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchedTheme {
                MyAppContent()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyAppContent() {
    val searchText = remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = searchText.value,
                        onValueChange = { searchText.value = it },
                        placeholder = { Text(text = "Search") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },
        content = {
            MovieList()
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieList() {
    val movies = listOf(
        "Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6", "Movie 7", "Movie 8", "Movie 9"
    )

    LazyVerticalGrid(cells = Fixed(2)) {
        items(movies.size) { index ->
            MovieItem(name = movies[index])
        }
    }
}

@Composable
fun MovieItem(name: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(0.7f)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WatchedTheme {
        MyAppContent()
    }
}
/*
Android estudos:

Watched: Estudo ao criar um app para a pessoa poder marcar qual filme e série já assistiu poder descobrir novas com base no que assistiu e poder bscar onde
tem pra assistit.

Tech's:
	Kotlin
	Jetpack Compose
	MVVC Patterns


1.Instale o Android Studio, se ainda não tiver feito isso.
	Crie um novo projeto Kotlin no Android Studio, selecionando a opção de usar Jetpack Compose.
2. Definição da Arquitetura MVVM:
	Crie as camadas da arquitetura MVVM: Model, View e ViewModel.
	O Model será responsável por lidar com a lógica de negócios, como fazer chamadas de API para buscar informações sobre filmes e séries.
	A ViewModel será o intermediário entre a View e o Model, expondo os dados necessários para a UI e realizando operações relacionadas à lógica de apresentação.
	A View será a interface do usuário, escrita usando o Jetpack Compose.
3. Implementação da Tela de Login:
	Crie a tela de login, onde os usuários poderão inserir suas credenciais.
	Use uma arquitetura de autenticação segura, como OAuth ou JWT.
4. Integração com um Banco de Dados Externo:
	Escolha um banco de dados externo, como Firebase Realtime Database, Firestore ou MongoDB.
	Configure o acesso ao banco de dados no aplicativo.
	Implemente as operações de leitura e escrita necessárias para salvar informações sobre os filmes e séries marcados como assistidos pelos usuários.
5. Implementação da Busca por Filmes e Séries:
	Integre uma API de filmes e séries, como a API do IMDb ou TMDb.
	Desenvolva a funcionalidade de busca para permitir que os usuários procurem filmes e séries dentro do aplicativo.
6. Marcação de Filmes e Séries Assistidos:
	Permita que os usuários marquem filmes, séries, temporadas ou episódios como assistidos.
	Salve essas informações no banco de dados externo para que os usuários possam acessá-las em qualquer dispositivo.
7. Integração com Serviços de Streaming:
	Integre APIs de serviços de streaming, como Netflix, Amazon Prime Video ou Disney+.
	Desenvolva uma funcionalidade que permita aos usuários verificar em qual serviço de streaming um filme ou série está disponível.
8. Testes e Depuração:
	Teste todas as funcionalidades do aplicativo para garantir que estejam funcionando corretamente.
	Corrija quaisquer bugs ou problemas de desempenho que surgirem durante os testes.
9. Implementação da UI com Jetpack Compose:
	Crie interfaces de usuário modernas e dinâmicas usando o Jetpack Compose.
	Desenvolva telas intuitivas e responsivas para proporcionar uma ótima experiência ao usuário.
10. Publicação na Google Play Store:
	Após concluir e testar o aplicativo, prepare-o para publicação na Google Play Store.
	Siga as diretrizes de publicação e certifique-se de fornecer todas as informações necessárias, como descrição do aplicativo, capturas de tela e ícones.
 */
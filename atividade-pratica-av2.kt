data class Aluno(val id: Int, var nome: String, var nota1: Double, var nota2: Double)

val alunos = mutableListOf<Aluno>()
var proximoId = 1

fun main() {
    while (true) {
        println("\n=== MENU ===")
        println("1. Adicionar Aluno")
        println("2. Listar Alunos")
        println("3. Editar Aluno")
        println("4. Remover Aluno")
        println("5. Ver Situação do Aluno")
        println("6. Sair")
        print("Escolha uma opção: ")

        when (readLine()?.toIntOrNull()) {
            1 -> adicionarAluno()
            2 -> listarAlunos()
            3 -> editarAluno()
            4 -> removerAluno()
            5 -> verSituacaoAluno()
            6 -> {
                println("Saindo...")
                break
            }
            else -> println("Opção inválida.")
        }
    }
}

fun adicionarAluno() {
    print("Digite o nome do aluno: ")
    val nome = readLine() ?: ""

    print("Digite a Nota 1: ")
    val nota1 = readLine()?.toDoubleOrNull() ?: return println("Nota inválida.")

    print("Digite a Nota 2: ")
    val nota2 = readLine()?.toDoubleOrNull() ?: return println("Nota inválida.")

    alunos.add(Aluno(proximoId++, nome, nota1, nota2))
    println("Aluno adicionado com sucesso!")
}

fun listarAlunos() {
    if (alunos.isEmpty()) {
        println("Nenhum aluno cadastrado.")
        return
    }

    println("\nLista de Alunos:")
    for (aluno in alunos) {
        println("${aluno.id}. ${aluno.nome} - Nota 1: ${aluno.nota1}, Nota 2: ${aluno.nota2}")
    }
}

fun editarAluno() {
    print("Digite o ID do aluno que deseja editar: ")
    val id = readLine()?.toIntOrNull()
    val aluno = alunos.find { it.id == id }

    if (aluno != null) {
        print("Novo nome (${aluno.nome}): ")
        val novoNome = readLine()
        if (!novoNome.isNullOrBlank()) aluno.nome = novoNome

        print("Nova Nota 1 (${aluno.nota1}): ")
        val novaNota1 = readLine()?.toDoubleOrNull()
        if (novaNota1 != null) aluno.nota1 = novaNota1

        print("Nova Nota 2 (${aluno.nota2}): ")
        val novaNota2 = readLine()?.toDoubleOrNull()
        if (novaNota2 != null) aluno.nota2 = novaNota2

        println("Aluno atualizado com sucesso!")
    } else {
        println("Aluno não encontrado.")
    }
}

fun removerAluno() {
    print("Digite o ID do aluno a remover: ")
    val id = readLine()?.toIntOrNull()
    val removido = alunos.removeIf { it.id == id }
    if (removido) {
        println("Aluno removido com sucesso.")
    } else {
        println("Aluno não encontrado.")
    }
}

fun verSituacaoAluno() {
    print("Digite o ID do aluno: ")
    val id = readLine()?.toIntOrNull()
    val aluno = alunos.find { it.id == id }

    if (aluno != null) {
        val media = (aluno.nota1 + aluno.nota2) / 2
        val situacao = when {
            media >= 7 -> "Aprovado ✅"
            media >= 5 -> "Recuperação ⚠️"
            else -> "Reprovado ❌"
        }

        println("Aluno: ${aluno.nome}")
        println("Média: %.2f".format(media))
        println("Situação: $situacao")
    } else {
        println("Aluno não encontrado.")
    }
}
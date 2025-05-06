// mutableListOf<Tarefa>()

data class Tarefa(val descricao: String, var concluida: Boolean = false)

fun main() {
  val tarefas = mutableListOf<Tarefa>()
  while (true) {
    println("\n--  MENU --")
    println("1. adicionar uma tarefa")
    println("2. Listar uma tarefa")
    println("3. Marcar tarefa como concluida")
    println("4. Sair")
    println("Escolha uma opção:")

    when (readLine()) {
        "1" -> {
            print("Digite a descrição da tarefa: ")
            val desc = readLine() ?: ""
            tarefas.add(Tarefa(desc))
            println("tarefa adicionada")
        }
        "2" -> {
          println("\n-- TAREFAS --")
          if (tarefas.isEmpty()) println("Nenhuma tarefa cadastrada.")
          else {
            tarefas.forEachIndexed { index, tarefa ->
              val status = if (tarefa.concluida) "[x]" else "[ ]"
              println("${index+1}. $status ${tarefa.descricao}")
            }
          }
        }
        "3" -> {
          println("Digite o número da Tarefa que deseja marcar como concluida: ")
          val indice = readLine()?.toIntOrNull()
          if (indice != null && indice in 1..tarefas.size){
            tarefas[indice - 1].concluida = true
            println("Tarefa marcada como concluída.")
          } else {
            println("Número inválido.")
          }
        }
        "4" -> {
            println("Saindo meu lindu...")
            break
        }
        else -> println("Opção inválida")
    }
  }
}
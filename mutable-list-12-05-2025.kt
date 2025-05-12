// mutableListOf<Tarefa>() 

data class Tarefa(val id: Int, var descricao: String, var concluida: Boolean)

val tarefas  = mutableListOf<Tarefas>
var proximoId = 1

fun main() {
  while (true) {
    println("\n--  MENU --")
    println("1. adicionar uma tarefa")
    println("2. Listar uma tarefa")
    println("3. Listar apenas tarefas pendentes")
    println("4. Marcar tarefa como concluida")
    println("5. Editar descrição de tarefa")
    println("6. Remover tarefa")
    println("7. Mostrar resumo")
    println("8. Sair")
    println("Escolha uma opção:")

     when (readLine()?.toIntOrNull()) {
    1 -> adicionarTarefas()
    2 -> listarTarefas()
    3 -> listarPendentes()
    4 -> concluirTarefa()
    5 -> editarTarefa()
    6 -> removerTarefa()
    7 -> mostrarResumo()
    8 -> {
      println("Saindo...")
      break
    }
      else -> println ("Opção inválida")
    }
  }
}

fun adicionarTarefa(){
  println("Digite a descrição da tarefa: ")
  val descricao = readLine() ?: ""
  tarefas.add(Tarefa(proximoId++, descricao, false))
  println("Tarefa adicionada com sucesso!")
}

fun listarTarefa(){
  if(tarefas.IsEmpty()){
    println("Nenhuma tarefa encontrada!")
    return
  }
  println("\n Lista de tarefas")
  for(t in tarefas ){
    val status = if (t.concluida) "🫡" else "❌"
    println("${t.id}. $status ${t.descricao}")
  }
}

fun listarPendentes(){
  val pendentes = tarefas.filter { !it.concluida}
  if(pendentes.isEmpty()) {
    println("Nenhuma tarefa pendente!)
    return
  }
  println("\n Tarefas Pendentes: ")
  for(t in pendentes) {
    println("${t.id}. ❌ ${t.descricao}")
  }
}

fun concluirTarefa() {
  println("Digite o ID da tarefa para concluí-la: ")
  val id = readLine()?.toIntOrNull
  val tarefa = tarefas.find {it.id == id}{
    if (tarefa != null) {
      tarefa.concluida = true
      println("Tarefa marcada como concluida")
    }
    else{
      println("Tarefa não encontrada")
    }
  }
}

fun editarTarefa(){
  println("Digite o ID da tarefa a ser editada: ")
  val id = readLine()?.toIntOrNull()
  val tarefa = tarefas.find { it.id == id }
  if(tarefa != null){
    println("Digite a nova descrição: ")
    val novaDescricao = readLine() ?: ""
    tarefa.descricao = novaDescricao
    println("Tarefa atualizada com sucesso!")
  } else {
    println("Tarefa não encontrada!")
  }
}

fun removerTarefa(){
  println("Digite o ID da tarefa a ser excluida: ")
  val id = readLine()?.toIntOrNull()
  val removida = tarefas.removeIf { it.id == id }
  if(removida) {
    println("Tarefa removida com sucesso!")
  } else {
    println("Tarefas não encontrada.")
  }
}

fun mostrarResumo(){
  val total = tarefas.size
  val concluidas = tarefas.count { it.concluida }
  println("Você concluiu $concluida de $total tarefas.")
}
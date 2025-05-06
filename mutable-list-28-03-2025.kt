// mutableListOf<People>()

class People(val nome: String, val idade: Int, val telefone: String)

fun main() {

  val ListPeople = mutableListOf<People>()

  println("ADICIONAR PESSOAS NA LISTA")

  println("Dados da pessoa q sera adicionada: ")
  println("Nome: henrique kunieda")
  println("telefone: 99999-9999")
  println("idade: 17")

  AddList("henrique kunieda",17, "99999-9999")
  AddList("gabriel rios",18, "99999-9999")
  AddList("janessa mayara",19, "99999-9999")

  ShowList()
}

fun AddList(nome: String, idade: Int, telefone: String) {
  ListPeople.add("${nome}", "${idade}", "${telefone}")
}

fun ShowList() {
  for (People in ListPeople) {
    println("Nome: ${People.nome}")
    println("Idade: ${People.idade}")
    println("Telefone: ${People.telefone}")
  }
}
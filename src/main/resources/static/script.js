/**
 * todoItem = Input field where user types in value to add to todo list
 * @param aTodo
 * @param parentEle
 */
function addToList(par){
    const aTodo = document.getElementById(par.id+"input").value;
    console.log(par);
    const neededText = par.id+"list";
    console.log(neededText);
    const listToAppend = document.getElementById(neededText);
    const listItem = document.createElement("li");
    listItem.textContent=aTodo;
    listToAppend.append(listItem);
}
function listOrTracker(){
    const userChoice = document.getElementById("userChoice");
    if(userChoice.value == "1"){
        addTrackerCard();
    }else if(userChoice.value == "2"){
        addToDoListCard();
    }else{
        alert("Oops! We havent implemented\nthat functionality yet.\nComing Soon though!!");
    }
}
function addTrackerCard(){
    const cardDash = document.getElementById("cardContainer");
    const template = document.getElementById("tracker");
    const aNewCard = template.cloneNode(true);
    //create h3 header for each list
    const title = document.createElement("h3");
    //get input from the user on what the title should be
    title.textContent = prompt("What would you like the title of this tracker to be?:","Safeway, Amazon, etc..." );
    aNewCard.id = (title.textContent+"tracker").toLowerCase();
    //since we're cloning from a hidden element on the page, lets remove that class
    aNewCard.classList.remove("hidden");
    aNewCard.classList.add("tracker");
    //just to remove unecessary styling
    aNewCard.style.setProperty("padding-top","0%");
    aNewCard.prepend(title);
    cardDash.prepend(aNewCard);
}
function addToDoListCard(){
    const cardDash = document.getElementById("cardContainer");
    const template = document.getElementById("todo");
    const aNewCard = template.cloneNode(true);
    //create h3 header for each list
    const title = document.createElement("h3");
    //get input from the user on what the title should be
    title.textContent = prompt("What would you like the title of this list to be?:","Vacation, Around the house, etc..." );
    aNewCard.id= (title.textContent+"todo").toLowerCase();
    aNewCard.name=aNewCard.id;
    const todoList = aNewCard.getElementsByClassName("todoList")[0];
    const todoListInput = aNewCard.getElementsByClassName("todoList")[1];
    console.log(todoList);
    console.log(todoListInput);
    todoList.id=(title.textContent+"todolist").toLowerCase();
    console.log(todoList.id);
    todoListInput.id=(aNewCard.id+"Input").toLowerCase();
    //since we're cloning from a hidden element on the page, lets remove that class
    aNewCard.classList.remove("hidden");
    aNewCard.classList.add("todo");
    //just to remove unecessary styling
    aNewCard.style.setProperty("padding-top","0%");
    aNewCard.appendChild(title);
    cardDash.prepend(aNewCard);
}
function deleteCheck(callingElement){
    const question = confirm("Are you sure you want to delete this card?\n(all related info will be lost)");
    if(question === true){
        callingElement.parentNode.remove();
    }
}
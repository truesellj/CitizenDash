function addCard(){
    const cardDash = document.getElementById("cardContainer");
    const aNewCard = document.createElement("div");
    aNewCard.setAttribute("class", "cardAdd");
    cardDash.prepend(aNewCard);
}
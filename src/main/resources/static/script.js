async function getData(zone) {
    const url = "http://localhost:8080/SightAPI?zone=";
    try {
        const response = await fetch(url+zone);
        // console.log(response);
        // if (!response.ok) {
        //     throw new Error(`Response status: ${response.status}`);
        // }

        const data = await response.json();
        console.log(data);
        redenerCards(data);
    } catch (error) {
        console.log("sfdfsdfsdf");
        console.error(error.message);
    }
}
function redenerCards(data) {
    let id=1;
    const cardArea = document.getElementById('card-area');
    cardArea.innerHTML = "";
    data.forEach((item) => {
        cardArea.innerHTML+=
            `<div class="flex justify-center place-items-center">
        <div class="card">
        <h3 class="card-item-text text-xl">${item.sightName}</h3>
        <p class="card-item-text tracking-widest text-lg">${item.zone}</p>
        <p class="card-item-text tracking-widest text-lg">${item.category}</p>
        <p class="card-item-text text-lg underline mb-4">
            <a href="https://www.google.com/maps/search/?api=1&query=${item.sightName}" target="_blank">${item.address}</a>
        </p>
        <input type="checkbox" id="card${id}" class="hidden peer" />
        <div class="flex justify-center ">
            <label for="card${id++}" class="card-button">詳細資訊</label>
        </div>
        <div class="inline-block max-h-0 overflow-hidden transition-all duration-300 peer-checked:max-h-[700px] overflow-y-auto scrollbar-transparent">
            <img class="h-full w-full object-cover peer-checked:my-6 py-2"
                 src="${item.photoUrl}"
                 alt="landscape photo">
            <p class="px-4 font-medium text-lg">${item.description}</p>
        </div>
    </div></div>`
    })
}

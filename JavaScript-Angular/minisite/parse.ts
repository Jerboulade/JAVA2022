
import * as data from './data.json';

type friend = {
    id : number,
    name : string
}

type user = {
    _id: string, 
    index: number, 
    guid: string, 
    isActive: boolean, 
    balance: string, 
    picture: string, 
    age: number, 
    eyeColor: string, 
    name: string, 
    gender: string, 
    company: string, 
    email: string, 
    phone: string,
    address: string,
    about: string,
    registered: string,
    latitude: string,
    longitude: string,
    tags: any,
    friends: friend[],
    greeting: string,
    favoriteFruit: string
}

//let ind = JSON.parse(data);
//console.log(`${i.name}'s favorite fruit is ${i.favoriteFruit}`)
console.log(data)

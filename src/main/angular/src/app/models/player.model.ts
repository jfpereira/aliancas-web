import {Posicao} from "./posicao.enum";

export class Player {
  id: number |undefined;
  email: string = "";
  nome: string = "";
  apelido: string = "";
  num: number = 0;
  altura: number = 0;
  peso: number = 0;
  posicao: Posicao = Posicao.STAFF;
}

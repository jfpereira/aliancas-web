import {PlayerRole} from "./playerRole.enum";

export class Player {
  id: number |undefined;
  email: string = "";
  name: string = "";
  surname: string = "";
  number: number = 0;
  height: number = 0;
  weight: number = 0;
  playerRole: PlayerRole = PlayerRole.STAFF;
}

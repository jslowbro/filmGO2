import { Role } from 'app/shared/model/enumerations/role.model';
import { Person } from 'app/shared/model/person.model';

export interface IPersonContainer {
  id?: number;
  role?: Role;
  personId?: number;
  filmId?: number;
}

export interface IRoleList {
  role?: Role;
  personList?: Person[];
}

export class PersonContainer implements IPersonContainer {
  constructor(public id?: number, public role?: Role, public personId?: number, public filmId?: number) {}
}

export class RoleList implements IRoleList {
  constructor(public role?: Role, public personList?: Person[]) {}
}

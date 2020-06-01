export interface IRating {
  id?: number | null;
  value?: number | null;
  filmId?: number | null;
  userLogin?: string | null;
  userId?: number | null;
}

export class Rating implements IRating {
  constructor(
    public id?: number | null,
    public value?: number | null,
    public filmId?: number | null,
    public userLogin?: string | null,
    public userId?: number | null
  ) {}
}

export interface IReview {
  id?: number;
  title?: string;
  text?: any;
  value?: number;
  filmId?: number;
  userLogin?: string;
  userId?: number;
}

export class Review implements IReview {
  constructor(
    public id?: number,
    title?: string,
    public text?: any,
    public value?: number,
    public filmId?: number,
    public userLogin?: string,
    public userId?: number
  ) {}
}

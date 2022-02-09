export class BuyForm {

  constructor(buyForm?: any) {
    this.Jwt = buyForm.Jwt || '';
    this.bookId = buyForm.bookId || 0;
    this.recipient = buyForm.recipient || '';
    this.address = buyForm.address || '';
    this.cardHolder = buyForm.cardHolder || '';
    this.cardNumber = buyForm.cardNumber || '';
    this.cardSecretCode = buyForm.cardSecretCode || 0;
    this.amount = buyForm.amount || 0;
    this.weight = buyForm.weight || 0;
  }

  Jwt?: string;
  bookId?: number;
  recipient?: string;
  address?: string;
  cardHolder?: string;
  cardNumber?: string;
  cardSecretCode?: number;
  amount?: number;
  weight?: number;

}

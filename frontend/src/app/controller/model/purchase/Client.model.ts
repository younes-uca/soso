import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ClientDto extends BaseDto{

    public fullName: string;

    public email: string;

    

    constructor() {
        super();

        this.fullName = '';
        this.email = '';

        }

}

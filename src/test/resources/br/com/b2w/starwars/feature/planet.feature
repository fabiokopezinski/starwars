#language: pt
@save
@delete

Funcionalidade: Listar, salvar e deletar 

    Esquema do Cenário: Consultar todos os planetas

    Quando realizar uma consulta de todos os planetas e informo o <limit> e o <offset>
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação

    Exemplos:
    
    | limit | offset | codigo_operacao |
    |  '2'  |  '0'   |  '200'          |
    
    
    Esquema do Cenário: Procurar por nome
		
		Dado que vou realizar um consulta por nome <nome>
    Quando realizar uma consulta
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação

    Exemplos:
    
    | nome      | codigo_operacao |
    |  'Endor'  |  '200'          |
    |  'Dagobah'|  '200'          |
    |   'TT'    |	 '404'          |
    
    
    
    
    Esquema do Cenário: Procurar por id
		
		Dado que vou realizar um consulta por id <id>
    Quando realizar uma consulta por id
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação

    Exemplos:
    
    |   id      | codigo_operacao |
    |  '999'    |  '200'          |
    |  '9999'   |  '200'          |
    |   '8090'  |	 '404'          |
    
    
    
    
    Esquema do Cenário: Cadastrar
		
		Dado que vou cadastrar um planet com  <name>, <climate>,<terrain_1>,<terrain_2> 
    Quando realizar o cadastro 
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação

    Exemplos:
    
    |   name        | climate     | terrain_1    | terrain_2  | codigo_operacao |
    |  'Alderaan'   | 'temperate' |  'grasslands'| 'mountains'|  '201'          |
    |  'Dagobah'    | 'murky'     |   'swamp'    | 'jungles'  |  '400'          |
    
    
    Esquema do Cenário: Delete com sucesso
		
		Dado que vou excluir um planeta no banco
    Quando realizar a deleção 
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação
    
     Exemplos:
    
    | codigo_operacao |
    |  '204'          |
    
    Esquema do Cenário: Delete sem sucesso
		
		Dado que vou excluir um planeta no banco com id invalido
    Quando realizar a deleção com id invalido
    Entao a API deve me retornar o código da operação <codigo_operacao> e os dados apresentados no corpo da solicitação
    
     Exemplos:
    
    | codigo_operacao |
    |  '404'          |
    
    
    
    
    
    
    
	// ��id����Ӧ�Ĺ�ϵmap
   public String[] getAllSon(String id, Map<String, String> map){
        ListIterator<String> condition = new ArrayList<String>(){{add(id);}}.listIterator();//�ɱ��ѯ����
        Set<String> set=new HashSet<String>(){{add(id);}};//��ѯ��� set��[3, 6, 9, 10]
        while (condition.hasNext()){
            String paid = condition.next();
            //entryset() ����map�и�����ֵ��ӳ���ϵ�ļ��ϡ� ѭ���ж���ֵ��ͬ��ȡ����Ӧ��keyֵ��ӵ��б��б�ѭ��ȡֵ��ѯ
            for (Map.Entry<String,String> entry : map.entrySet()){
                if (paid.equals(entry.getValue())){//Ϊ��id��ʱ��
                    if (set.add(entry.getKey())){
                        condition.add(entry.getKey());
                    //��Ϊadd�������ӵ���ǰָ�����һ��λ�� Ҫ��previous��֮ǰ�ġ� ����ָ��λ��
                    condition.previous();
                    }
                }
            }
        }
		//new String[0]��ģ�����ã�ָ���������ͣ�����Ϊset���ȡ������ǴӴ�С��set�Ǵ�С����
        String[] result= set.toArray(new String[0]);
        return result;
    }
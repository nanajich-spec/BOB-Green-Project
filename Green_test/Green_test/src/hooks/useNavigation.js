import { useAuth } from './useAuth';
import { useMemo } from 'react';
import { NAVIGATION_BY_ROLE } from '../config/routes';

export const useNavigation = () => {
  const { userRole } = useAuth();

  const navigation = useMemo(() => {
    return NAVIGATION_BY_ROLE[userRole] || [];
  }, [userRole]);

  return {
    navigation,
    userRole
  };
};
